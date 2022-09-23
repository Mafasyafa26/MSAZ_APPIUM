package coid.nexsoft.app.pageobject;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Calculator {

	public AndroidDriver<MobileElement> driver;

	public Calculator(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// Locator number
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_1")
	private MobileElement btnSatu;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_2")
	private MobileElement btnDua;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_3")
	private MobileElement btnTiga;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_4")
	private MobileElement btnEmpat;

	// locator aritmatika
	@AndroidFindBy(id = "com.google.android.calculator:id/op_add")
	private MobileElement btnTambah;
	@AndroidFindBy(id = "com.google.android.calculator:id/op_sub")
	private MobileElement btnKurang;
	@AndroidFindBy(id = "com.google.android.calculator:id/op_mul")
	private MobileElement btnKali;
	@AndroidFindBy(id = "com.google.android.calculator:id/op_div")
	private MobileElement btnBagi;
	@AndroidFindBy(id = "com.google.android.calculator:id/eq")
	private MobileElement btnSamaDengan;
	@AndroidFindBy(id = "com.google.android.calculator:id/clr")
	private MobileElement btnClear;

	// locator result
	@AndroidFindBy(id = "com.google.android.calculator:id/result_final")
	private MobileElement result;

	// Method
	public void calcAdd() {
		btnSatu.click();
		btnTambah.click();
		btnDua.click();
		btnSamaDengan.click();
	}

	public void calcMul() {
		btnEmpat.click();
		btnKurang.click();
		btnTiga.click();
		btnSamaDengan.click();
	}

	public void calcDiv() {
		btnEmpat.click();
		btnBagi.click();
		btnDua.click();
		btnSamaDengan.click();
	}

	public void calcEq() {
		btnEmpat.click();
		btnKali.click();
		btnDua.click();
		btnSamaDengan.click();
	}

	//
	public String getTxtResult() {
		return result.getText();
	}

	public void clear() {
		btnBagi.click();
	}
}
