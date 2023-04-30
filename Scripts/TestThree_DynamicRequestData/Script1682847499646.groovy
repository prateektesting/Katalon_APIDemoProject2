import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

response1 = WS.sendRequest(findTestObject('CountryInfoSoapService/GetCountryListByNames'))

String xml1 = response1.responseBodyContent

def dataValue = new XmlSlurper().parseText(xml1)

def countryCode = dataValue.ListOfCountryNamesByNameResult.tCountryCodeAndName[3].sISOCode.text()

println('The CountryCode is - ' + countryCode)

GlobalVariable.countryCode = countryCode

responseBetween=WS.sendRequest(findTestObject('CountryInfoSoapService/GetCapital'))

String xml2 = responseBetween.responseBodyContent

def dataValue2 = new XmlSlurper().parseText(xml2)

def capitalCity = dataValue2.CapitalCityResult.text()

println("The Capital of country code "+countryCode+ " is - "+capitalCity)

response2 = WS.sendRequest(findTestObject('CountryInfoSoapService/GetCurrency'))

String xml3 = response2.responseBodyContent

def dataValue3 = new XmlSlurper().parseText(xml3)

def currency = dataValue3.CountryCurrencyResult.sName.text()

println((('The Currency of country code ' + countryCode) + ' is - ') + currency)

