package ru.tinkoff.favouritepersons.Screens


import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KButton
import ru.tinkoff.favouritepersons.R
import ru.tinkoff.favouritepersons.presentation.PersonErrorMessages

class KaspressoFormEditStudentsScreen : KScreen<KaspressoFormEditStudentsScreen>() {

    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    private val nameInputField = KEditText { withId(R.id.et_name) }
    private val surnameInputField = KEditText { withId(R.id.et_surname) }
    private val genderInputField = KEditText { withId(R.id.et_gender) }
    private val birthdateInputField = KEditText { withId(R.id.et_birthdate) }
    private val emailInputField = KEditText { withId(R.id.et_email) }
    private val phoneInputField = KEditText { withId(R.id.et_phone) }
    private val addressInputField = KEditText { withId(R.id.et_address) }
    private val linkImageInputField = KEditText { withId(R.id.et_image) }
    private val ratingInputField = KEditText { withId(R.id.et_score) }
    private val submitButton = KButton { withId(R.id.submit_button) }
    private val errorBirthdateText = PersonErrorMessages.BIRTHDATE.errorMessage
    private val errorRatingText = PersonErrorMessages.RATING.errorMessage
    private val errorEmailText = PersonErrorMessages.EMAIL.errorMessage


    fun inputName(name: String) {
        nameInputField.replaceText(name)
    }

    fun inputSurname(surname: String) {
        surnameInputField.replaceText(surname)
    }

    fun inputGender(gender: String) {
        genderInputField.replaceText(gender)
    }

    fun inputBirthdate(birthdate: String) {
        birthdateInputField.replaceText(birthdate)
    }

    fun inputEmail(email: String) {
        emailInputField.replaceText(email)
    }

    fun inputPhone(phone: String) {
        phoneInputField.replaceText(phone)
    }

    fun inputAddress(address: String) {
        addressInputField.replaceText(address)
    }

    fun inputLinkPhoto(link: String) {
        linkImageInputField.replaceText(link)
    }

    fun inputRating(rating: String) {
        ratingInputField.replaceText(rating)
    }

    fun clickSubmit() {
        submitButton.click()
    }

    fun checkErrorEnterBirthdate(errorBirthdate: String) {
        assert(errorBirthdateText.contains(errorBirthdate))
    }

    fun checkErrorEnterRating(errorRating: String) {
        assert(errorRatingText.contains(errorRating))
    }

    fun checkErrorEnterEmail(errorEmail: String) {
        assert(errorEmailText.contains(errorEmail))
    }
}