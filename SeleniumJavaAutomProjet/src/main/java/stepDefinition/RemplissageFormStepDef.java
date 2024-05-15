package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RemplissageFormStepDef {
	// C'est aussi possible de créer un user avec ces valeurs en défaut ou même de passer ces valeurs dans le fichier feature
	public static WebDriver driver;
	public static String prenom = "Amine";
	public static String nom = "DUTEST";
	public static String entreprise = "MonEnt";
	public static String adresse = "1 rue de Paris, 75000";
	public static String mail = "test@ent.fr";
	public static String indicatif = "0033 ";
	public static String tel = "1122334455 ";
	public static String texte = "contact contact contact contact contact contact";
	private String message;
	
	@Given("un utilisateur accède au formulaire de contact")
	public void un_utilisateur_accède_au_formulaire_de_contact() {
	    // Write code here that turns the phrase above into concrete actions
	    System.setProperty("webdriver.geckodriver", ".\\Include\\geckodriver.exe");
	    driver = new FirefoxDriver();
	    driver.get("https://form.jotform.com/241263471608354");
	    assertEquals("Formulaire de contact basique", driver.getTitle());
	    System.out.println(driver.getTitle());
	    
	}
	@Given("saisit les champs obligatoires")
	public void saisit_les_champs_obligatoires() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("first_24")).sendKeys(prenom);
		TimeUnit.SECONDS.sleep(2);
		driver.findElement(By.id("last_24")).sendKeys(nom);
		TimeUnit.SECONDS.sleep(2);
		driver.findElement(By.id("input_26")).sendKeys(entreprise);
		TimeUnit.SECONDS.sleep(2);
		driver.findElement(By.id("input_15")).sendKeys(adresse);
		TimeUnit.SECONDS.sleep(2);
		driver.findElement(By.id("input_3")).sendKeys(mail);
		TimeUnit.SECONDS.sleep(2);
		driver.findElement(By.id("input_25_area")).sendKeys(indicatif);
		TimeUnit.SECONDS.sleep(2);
		driver.findElement(By.id("input_25_phone")).sendKeys(tel);
		TimeUnit.SECONDS.sleep(2);
		driver.findElement(By.id("input_6")).sendKeys(texte);
		TimeUnit.SECONDS.sleep(2);
		//driver.findElement(By.id("")).sendKeys("");
	    
	}
	@Given("selectionne le secteur de l'entreprise")
	public void selectionne_le_secteur_de_l_entreprise() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("input_8")).click();
		Select secteurSelec = new Select(driver.findElement(By.id("input_8")));
		secteurSelec.selectByIndex(1);
		TimeUnit.SECONDS.sleep(2);
	}
	@Given("accepte le traitement des données")
	public void accepte_le_traitement_des_données() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("input_12_0")).sendKeys(Keys.SPACE);
		TimeUnit.SECONDS.sleep(2);
	}
	@Given("clique sur le bouton envoyer")
	public void clique_sur_le_bouton_envoyer() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		TimeUnit.SECONDS.sleep(10);
		driver.findElement(By.id("input_16")).click();
	}
	@Then("le message {string} s'affiche")
	public void le_message_s_affiche(String string) {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement element = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class,'thankyou-sub-text ty-text')]")));
		message = element.getText();
		assertEquals(string, message);
	    System.out.println("Après vérification le message s'affiche : " + message);
	}
}