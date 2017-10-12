package com.infongen.selenium.example;

import com.infongen.selenium.businessobjects.Article;
import com.infongen.selenium.pageobjects.v3test.main.V3ArticleDocument;
import com.infongen.selenium.service.DocumentService;
import com.infongen.selenium.steps.v3test.SettingsSteps;
import com.infongen.selenium.steps.v3test.verification.VerificationSettingsSteps;
import com.infongen.selenium.steps.v3test.verification.VerificationV3TestPageSteps;
import com.infongen.selenium.test.ArticlesDataProvider;
import com.infongen.selenium.test.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyInterceptor.class)
public class TestovTest extends BaseTest {

  private static final String ARTICLE_ORIGIN = "Source Name";

  private String documentTitle;

  @Autowired private VerificationV3TestPageSteps verificationV3TestPageSteps;

  @Autowired private VerificationSettingsSteps verificationSettingsSteps;

  @Autowired private SettingsSteps settingsSteps;

  @Autowired private DocumentService documentService;

  @Value("${v3.user.name}")
  private String user;

  @Value("${v3.user.password}")
  private String password;

  @BeforeClass(alwaysRun = true)
  @Override
  public void login() {
    v3TestPage = loginSteps.loginToV3Portal(user, password);
  }

  @BeforeClass(dependsOnMethods = "login")
  public void setArticleOrigin() {
    settingsSteps.setArticleOriginPresentation(ARTICLE_ORIGIN);
    v3TestPageSteps.openHomePage();
  }

  @Postcondition(methodName = "subscribe")
  @Test(groups = "forAfterTest")
  public void subscribe() {
    v3TestPageSteps.performSearch(documentTitle);
    V3ArticleDocument document = v3TestPage.getContent().getDocumentByTitle(documentTitle);
    String source = document.getSourceLink().getText();
    settingsSteps.subscribeSource(source);
  }

  @Description("Open source menu")
  @TmsLink("1")
  @Test(
    groups = "home_screen",
    dataProviderClass = ArticlesDataProvider.class,
    dataProvider = "getTestArticle"
  )
  public void testOpenSourceMenu(final Article article) {
    documentService.createDocument(article);
    documentTitle = article.getHeadline();
    waitForDocument(documentTitle);
    v3TestPageSteps.openSourceMenu(documentTitle);
  }


  @Description("Select 'Filter by source' in source menu")
  @TmsLink("2")
  @Test(groups = "home_screen", dependsOnMethods = "testOpenSourceMenu")
  public void testSelectFilterBySourceInSourceMenu() {
    v3TestPageSteps.performSearch(documentTitle);
    v3TestPageSteps.clickFilterBySource(documentTitle);

    V3ArticleDocument document = v3TestPage.getContent().getDocumentByTitle(documentTitle);
    String source = document.getFeedLink().getText();
    verificationV3TestPageSteps.verifyThatAllDocumentsContainOnlySpecificSource(source);
  }

  @AfterMethod(methodName = "subscribe")
  @Description("Select 'Unsubscribe source' in source menu")
  @TmsLink("3")
  @Test(dependsOnMethods = "testOpenSourceMenu", groups = "home_screen")
  public void testUnsubscribeSource() {
    v3TestPageSteps.performSearch(documentTitle);
    v3TestPageSteps.openSourceMenu(documentTitle);
    v3TestPageSteps.clickUnsubscribeSource(documentTitle);
    settingsSteps.openSourceLibraryMenu();

    V3ArticleDocument document = v3TestPage.getContent().getDocumentByTitle(documentTitle);
    String source = document.getFeedLink().getText();
    settingsSteps.searchForSource(source);
    verificationSettingsSteps.verifyAreSourcesUnsubscribed(Collections.singletonList(source));
  }
  @AfterMethod(methodName = "subscribe")
  @Description("Select 'Edit subscriptions' in source menu")
  @TmsLink("4")
  @Test(dependsOnMethods = "testOpenSourceMenu", groups = "home_screen")
  public void testEditSource() {
    v3TestPageSteps.performSearch(documentTitle);
    V3ArticleDocument document = v3TestPage.getContent().getDocumentByTitle(documentTitle);
    String source = document.getFeedLink().getText();

    v3TestPageSteps.clickEditSubscription(documentTitle);
    verificationSettingsSteps.verifyIsSourceLibraryMenuContainSources(
        Collections.singletonList(source));
  }
}
