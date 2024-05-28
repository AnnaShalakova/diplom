package ru.tinkoff.favouritepersons.Tests

import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import ru.tinkoff.favouritepersons.Screens.KaspressoFormEditStudentsScreen
import ru.tinkoff.favouritepersons.Screens.KaspressoListStudentsScreen
import ru.tinkoff.favouritepersons.presentation.activities.MainActivity

class KaspressoAddFormStudentsTest : TestCase() {

    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainActivity>()

    val listScreen = KaspressoListStudentsScreen()
    val addScreen = KaspressoFormEditStudentsScreen()

    val name = "Ivan"
    val surname = "Petrov"
    val gender = "М"
    val birthdate = "1990-02-03"
    val email = "IvanP@gmail.com"
    val phone = "79999993322"
    val address = "Moscow"
    val linkPhoto = "https://i.pinimg.com/736x/f1/a8/76/f1a87626ca95252f174bba594dc16fdc.jpg"
    val rating = "60"

    val incorrectEmail = "testtest.com"
    val incorrectBirthdate = "19900102"
    val incorrectRating = "105"

    val errorBirthdateText = "Поле должно быть заполнено в формате 1990-12-31"
    val errorRatingText = "Поле должно быть заполнено двузначным числом"
    val errorEmailText = "Поле должно быть заполнено в формате mail@gmail.com"

    val editNewName = "Fintech"

    @Test
    fun kaspressoSaveFormWithOnlyImportantData() = run {
        listScreen.clickAdd()
        listScreen.clickAddManually()
        addScreen.inputName(name)
        addScreen.inputSurname(surname)
        addScreen.inputBirthdate(birthdate)
        addScreen.inputRating(rating)
        addScreen.clickSubmit()
        listScreen.checkStudentInListByName(name,0)
    }

    @Test
    fun kaspressoSaveFormWithAllData() = run {
        listScreen.clickAdd()
        listScreen.clickAddManually()
        addScreen.inputName(name)
        addScreen.inputSurname(surname)
        addScreen.inputGender(gender)
        addScreen.inputBirthdate(birthdate)
        addScreen.inputEmail(email)
        addScreen.inputPhone(phone)
        addScreen.inputAddress(address)
        addScreen.inputLinkPhoto(linkPhoto)
        addScreen.inputRating(rating)
        addScreen.clickSubmit()
        listScreen.checkStudentInListByName(name,0)
    }

    @Test
    fun kaspressoSaveFormWithIncorrectEmail() = run {
        listScreen.clickAdd()
        listScreen.clickAddManually()
        addScreen.inputName(name)
        addScreen.inputSurname(surname)
        addScreen.inputGender(gender)
        addScreen.inputBirthdate(birthdate)
        addScreen.inputEmail(incorrectEmail)
        addScreen.inputPhone(phone)
        addScreen.inputAddress(address)
        addScreen.inputLinkPhoto(linkPhoto)
        addScreen.inputRating(rating)
        addScreen.clickSubmit()
        addScreen.checkErrorEnterEmail(errorEmailText)
}

    @Test
    fun kaspressoSaveFormWithIncorrectBirthdate() = run {
        listScreen.clickAdd()
        listScreen.clickAddManually()
        addScreen.inputName(name)
        addScreen.inputSurname(surname)
        addScreen.inputGender(gender)
        addScreen.inputBirthdate(incorrectBirthdate)
        addScreen.inputEmail(email)
        addScreen.inputPhone(phone)
        addScreen.inputAddress(address)
        addScreen.inputLinkPhoto(linkPhoto)
        addScreen.inputRating(rating)
        addScreen.clickSubmit()
        addScreen.checkErrorEnterBirthdate(errorBirthdateText)
    }

    @Test
    fun kaspressoSaveFormWithIncorrectRating() = run {
        listScreen.clickAdd()
        listScreen.clickAddManually()
        addScreen.inputName(name)
        addScreen.inputSurname(surname)
        addScreen.inputGender(gender)
        addScreen.inputBirthdate(birthdate)
        addScreen.inputEmail(email)
        addScreen.inputPhone(phone)
        addScreen.inputAddress(address)
        addScreen.inputLinkPhoto(linkPhoto)
        addScreen.inputRating(incorrectRating)
        addScreen.clickSubmit()
        addScreen.checkErrorEnterRating(errorRatingText)
    }

    @Test
    fun kaspressoEditFormStudent() = run {
        listScreen.clickStudentInList(0)
        addScreen.inputName(editNewName)
        addScreen.clickSubmit()
        listScreen.checkStudentInListByName(editNewName,0)
    }
}