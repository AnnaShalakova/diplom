package ru.tinkoff.favouritepersons.Tests

import androidx.test.ext.junit.rules.activityScenarioRule
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.junit.WireMockRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import ru.tinkoff.favouritepersons.Screens.KaspressoListStudentsScreen
import ru.tinkoff.favouritepersons.PreferenceRule
import ru.tinkoff.favouritepersons.WireMockHelper
import ru.tinkoff.favouritepersons.presentation.activities.MainActivity

class KaspressoListStudentsTest : TestCase() {

    @get:Rule
    val prefs = PreferenceRule()

    @get: Rule
    val mock = WireMockRule(5000)

    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainActivity>()

    val listScreen = KaspressoListStudentsScreen()

    val emptyListText = "Нет ни одного человечка( \n Нажми на кнопку в правом нижнем углу"

    @Test
    fun kaspressoAddStudentFromNetwork() = run {

        WireMock.stubFor(
            WireMock.get("/api/")
                .willReturn(
                    WireMock.aResponse()
                        .withStatus(200)
                        .withBody(WireMockHelper.fileToString("add_response.json"))
                )
        )
        listScreen.clickAdd()
        listScreen.clickAddFromNetwork()
        listScreen.checkStudentInListByName("Александр",0)
    }





    @Test
    fun kaspressoDeleteStudentFromList() = run {
        listScreen.clickAdd()
        listScreen.clickAddFromNetwork()
        listScreen.deleteStudentFromList(0)
        listScreen.checkEmptyListText(emptyListText)
    }

    @Test
    fun kaspressoScrollListStudent() = run {
        listScreen.clickAdd()
        listScreen.clickAddFromNetwork()
        listScreen.clickAddFromNetwork()
        listScreen.clickAddFromNetwork()
        listScreen.clickAddFromNetwork()
        listScreen.clickAddFromNetwork()
        listScreen.clickAddFromNetwork()
        listScreen.clickAddFromNetwork()
        listScreen.clickAddFromNetwork()
        listScreen.clickAddFromNetwork()
        listScreen.swipeStudentInList(0)
        listScreen.swipeStudentInList(3)
        listScreen.swipeStudentInList(6)
        listScreen.swipeStudentInList(9)
    }

    @Test
    fun kaspressoCheckEmptyListText() = run {
        listScreen.checkEmptyListText(emptyListText)
    }

    @Test
    fun kaspressoSortByRating() = run {
        listScreen.clickSort()
        listScreen.clickSortByRating()
        listScreen.checkStudentInListByRating("33",0)
        listScreen.checkStudentInListByRating("22",1)
        listScreen.checkStudentInListByRating("11",2)
    }

    @Test
    fun kaspressoSortByName() = run {
        listScreen.clickSort()
        listScreen.clickSortByName()
        listScreen.checkStudentInListByName("Александр",0)
        listScreen.checkStudentInListByName("Борис",1)
        listScreen.checkStudentInListByName("Владимир",2)
    }

    @Test
    fun kaspressoSortByAge() = run {
        listScreen.clickSort()
        listScreen.clickSortByAge()
        listScreen.checkStudentInListByAge("33",0)
        listScreen.checkStudentInListByAge("22",1)
        listScreen.checkStudentInListByAge("11",2)
    }
}