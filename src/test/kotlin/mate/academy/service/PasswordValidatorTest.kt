package mate.academy.service

import mate.academy.exception.PasswordValidationException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class PasswordValidatorTest {

    private val validator = PasswordValidator()

    @Test
    fun testValidatePasswords_validPasswordMatchingRepeat() {
        assertDoesNotThrow {
            validator.validate("validPassword123", "validPassword123")
        }
    }

    @Test
    fun testValidatePasswords_shortPasswordThrowsException() {
        val exception = assertThrows<PasswordValidationException> {
            validator.validate("short", "short")
        }
        assertEquals("Wrong passwords", exception.message)
    }

    @Test
    fun testValidatePasswords_mismatchedPasswordsThrowException() {
        val exception = assertThrows<PasswordValidationException> {
            validator.validate("Password12345", "Password54321")
        }
        assertEquals("Wrong passwords", exception.message)
    }
}

