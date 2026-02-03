package mate.academy.service

import mate.academy.exception.PasswordValidationException

class PasswordValidator {
    fun validate(password: String, repeatPassword: String) {
        if (password.length < 10 || password != repeatPassword) {
            throw PasswordValidationException("Wrong passwords")
        }
    }
}

