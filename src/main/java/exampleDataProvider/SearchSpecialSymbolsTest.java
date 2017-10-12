package com.infongen.selenium.test.search;

import static java.util.Collections.singletonList;

import com.infongen.selenium.test.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class SearchSpecialSymbolsTest extends BaseTest {

  @Description(
      "Search by word with wildcard at the beginning of word from Search field on Home page (OR operation by default if there are no operands or +/-/| symbols before search word) )")
  @TmsLink("2.2.6.1")
  @Test(groups = "search_spesial_symbols")
  public void testSearchByWordWithWildcardAtTheBeginningOfWord(
      String searchQuery, String expectedMessage) {
    v3TestPageSteps.performSearch(searchQuery);
    verificationV3TestPageSteps.verifyIsWarningMessageAreaContainText(expectedMessage);
    verificationV3TestPageSteps.verifyAreCriteriaPresent(singletonList(searchQuery));
  }
}
