package mate.academy.service

import mate.academy.model.User
import mate.academy.exception.PasswordValidationException

class UserService {

    private val passwordValidator = PasswordValidator()

    fun saveUser(user: User): String {
        return "User ${user.username} saved successfully."
    }

    fun registerUser(username: String, password: String, repeatPassword: String): String {
        return try {
            passwordValidator.validate(password, repeatPassword)
            saveUser(User(username, password))
        } catch (e: PasswordValidationException) {
            "Your passwords are incorrect. Try again."
        }
    }
}

