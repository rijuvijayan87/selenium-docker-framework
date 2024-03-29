package com.searchmodule.test;

import com.searchmodule.pages.SearchPage;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    @Parameters({"keyword"})
    public void search(String keyword) {
        System.out.println("Search Test Cases");
        SearchPage searchPage = new SearchPage(_driver);
        searchPage.goTo();
        searchPage.doSearch(keyword);
        searchPage.goToVideos();
        int size = searchPage.getResults();
        Assert.assertTrue(size > 0);
    }

}
