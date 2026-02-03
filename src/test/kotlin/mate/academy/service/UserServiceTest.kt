package mate.academy.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UserServiceTest {
    private val userService = UserService()

    @Test
    fun testRegisterUser_validPasswordMatchingRepeat() {
        val result = userService.registerUser("testUser", "password123", "password123")
        assertEquals("User testUser saved successfully.", result)
    }

    @Test
    fun testRegisterUser_passwordAndRepeatMismatch() {
        val result = userService.registerUser("testUser", "password123", "password124")
        assertEquals("Your passwords are incorrect. Try again.", result)
    }

    @Test
    fun testRegisterUser_passwordValidatorThrowsException() {
        val invalidPassword = "invalid"
        val result = userService.registerUser("testUser", invalidPassword, invalidPassword)
        assertEquals("Your passwords are incorrect. Try again.", result)
    }

    @Test
    fun testRegisterUser_emptyUsername() {
        val result = userService.registerUser("", "password123", "password123")
        assertEquals("User  saved successfully.", result)
    }

    @Test
    fun testRegisterUser_emptyPassword() {
        val result = userService.registerUser("testUser", "", "")
        assertEquals("Your passwords are incorrect. Try again.", result)
    }

    @Test
    fun testRegisterUser_specialCharactersInUsernameAndPassword() {
        val result = userService.registerUser("test@User", "p@ssw0rd!QQQ", "p@ssw0rd!QQQ")
        assertEquals("User test@User saved successfully.", result)
    }

    @Test
    fun testRegisterUser_passwordAndRepeatSameObject() {
        val password = "password123"
        val result = userService.registerUser("testUser", password, password)
        assertEquals("User testUser saved successfully.", result)
    }
}

