package ru.tinkoff.favouritepersons.Screens

import android.view.View
import androidx.test.espresso.action.ViewActions
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import ru.tinkoff.favouritepersons.R

class KaspressoListStudentsScreen : KScreen<KaspressoListStudentsScreen>() {

    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    private val studentList = KRecyclerView(
        builder = { withId(R.id.rv_person_list) },
        itemTypeBuilder = { itemType(::StudentCard) }
    )

    private val addButton = KButton { withId(R.id.fab_add_person) }
    private val addFromNetworkButton = KButton { withId(R.id.fab_add_person_by_network) }
    private val addManuallyButton = KButton { withId(R.id.fab_add_person_manually) }
    private val sortButton = KButton { withId(R.id.action_item_sort) }
    private val sortAgeButton = KButton { withId(R.id.bsd_rb_age) }
    private val sortRatingButton = KButton { withId(R.id.bsd_rb_rating) }
    private val sortNameButton = KButton { withId(R.id.bsd_rb_name) }
    private val emptyListText = KTextView { withId(R.id.tw_no_persons) }
    private val personNameText = KTextView { withId(R.id.person_name) }
    private val personPrivateInfoText = KTextView { withId(R.id.person_private_info) }
    private val personEmailText = KTextView { withId(R.id.person_email) }
    private val personPhoneText = KTextView { withId(R.id.person_phone) }
    private val personAddressText = KTextView { withId(R.id.person_address) }
    private val personRatingText = KTextView { withId(R.id.person_rating) }

    fun clickAdd() {
        addButton.click()
    }

    fun clickAddFromNetwork() {
        addFromNetworkButton.click()
    }

    fun clickAddManually() {
        addManuallyButton.click()
    }

    fun clickSort() {
        sortButton.click()
    }

    fun clickSortByAge() {
        sortAgeButton.click()
    }

    fun clickSortByRating() {
        sortRatingButton.click()
    }

    fun clickSortByName() {
        sortNameButton.click()
    }

    fun clickStudentInList(position: Int) {
        studentList.childAt<StudentCard>(position) {
            this.click()
        }
    }

    fun deleteStudentFromList(position: Int) {
        studentList.childAt<StudentCard>(position) {
            this.view.perform(ViewActions.swipeLeft())
        }
    }

    fun checkEmptyListText(description: String) {
        emptyListText.hasText(description)
    }

    fun checkPersonNameText(name: String) {
        personNameText.hasText(name)
    }

    fun checkPersonPrivateInfoNameText(privateInfo: String) {
        personPrivateInfoText.hasText(privateInfo)
    }

    fun checkPersonEmailText(email: String) {
        personEmailText.hasText(email)
    }

    fun checkPersonPhoneText(phone: String) {
        personPhoneText.hasText(phone)
    }

    fun checkPersonAddressText(address: String) {
        personAddressText.hasText(address)
    }

    fun checkPersonRatingText(rating: String) {
        personRatingText.hasText(rating)
    }

    fun checkStudentInListByName(name: String, position: Int) {
        studentList.childAt<StudentCard>(position) {
            this.studentName.containsText(name)
        }
    }

    fun checkStudentInListByRating(rating: String, position: Int) {
        studentList.childAt<StudentCard>(position) {
            this.studentName.containsText(rating)
        }
    }

    fun checkStudentInListByAge(age: String, position: Int) {
        studentList.childAt<StudentCard>(position) {
            this.studentName.containsText(age)
        }
    }

    fun swipeStudentInList(position: Int) {
        studentList.childAt<StudentCard>(position) {
            this.view.perform(ViewActions.swipeUp())
        }
    }
}

private class StudentCard(matcher: Matcher<View>) : KRecyclerItem<StudentCard>(matcher) {
    val studentName = KTextView(matcher) { withId(R.id.person_name) }
}