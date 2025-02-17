import com.example.coffee.entities.Role
import com.example.coffee.entities.User
import com.example.coffee.repositories.UserRepository
import com.example.coffee.services.UserService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import kotlin.test.assertEquals
import org.mockito.Mockito.`when`
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


@ExtendWith(MockitoExtension::class)
class UserServiceTest {

    @Mock
    private lateinit var userRepository: UserRepository

    @Mock
    private lateinit var passwordEncoder: BCryptPasswordEncoder

    @InjectMocks
    private lateinit var userService: UserService

    @Test
    fun testCreateUser() {
        val bencoer:BCryptPasswordEncoder = BCryptPasswordEncoder()
        val email = "John@gmail.com"
        val rawPassword = "Doe"
        val encodedPassword = bencoer.encode(rawPassword)
        val role = Role.USER

        val createdUser = User(1L, email, rawPassword, role)

        // Mock password encoding
        `when`(passwordEncoder.encode(rawPassword)).thenReturn(encodedPassword)

        // Mock repository save behavior
        `when`(userRepository.save(Mockito.any(User::class.java))).thenReturn(createdUser)

        // Call the actual method
        val actualUser = userService.createUser(createdUser)

        // Verify that password encoding was called
        Mockito.verify(passwordEncoder).encode(rawPassword)

        // Verify repository save was called
        Mockito.verify(userRepository).save(Mockito.any(User::class.java))

        // Assertions
        assertEquals(email, actualUser?.email)
        assertEquals(encodedPassword, actualUser?.password) // Ensure the password is encoded
        assertEquals(role, actualUser?.role)
    }
}
