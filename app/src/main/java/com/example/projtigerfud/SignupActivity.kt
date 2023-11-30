package com.example.projtigerfud

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projtigerfud.databinding.ActivitySignupBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        // these lines help initialize and set up the user interface for the SignupPage activity using View Binding.
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.reference.child("users") //users means data base so whenever u want to access ur database u have to mention path string as users

        binding.signupButton.setOnClickListener {
            // username and password that user will write the details we will take them with the help of text.toString
            val signupUsername = binding.signupUsername.text.toString()
            val signupPassword = binding.signupPassword.text.toString()

            // pag dalawa is not empty ang username and password, i call this signup user method which created before sa loob neto it will pass signupUsername, signupPassword
            if(signupUsername.isNotEmpty() && signupPassword.isNotEmpty()){
                Toast.makeText(this@SignupActivity, "proceed to login", Toast.LENGTH_SHORT).show()

                signUpUser(signupUsername, signupPassword)
            }else { // pag yung user black lang nilagay it will toast as all fields are mandatory
                Toast.makeText(this@SignupActivity, "All Fields are mandatory", Toast.LENGTH_SHORT).show()
            }
        }

        // if the user will click on it then it will redirect sa login activity sa tulong ni mr intent
        binding.loginRedirect.setOnClickListener {
            Toast.makeText(this@SignupActivity, "Signup Succesful", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@SignupActivity, LoginActivity::class.java))
            finish()
        }

    }

    private fun signUpUser(username: String, password: String){
        // in the "by child" it will sort the data by the child key that is username and equal to basically filters the data of all the stored user name that matches with the username given by the user
        databaseReference.orderByChild("username").equalTo(username).addListenerForSingleValueEvent(object : ValueEventListener{
            // inside the value event listener we have override on data changes
            override fun onDataChange(datasnapshot: DataSnapshot) {

                // so ito yung logic nya if data snapshot does not exist then we are supported to perform the below action but if the snapshot exists then it will throw a toast as user already exists
                // data snapshot means is an object that represents the specific location in firebase real-time database
                // so in caster words HAHAHAHA if yung data already exists in the database so pupunta sys sa else otherwise mag create sya ng new user
                if (!datasnapshot.exists()){
                    val id = databaseReference.push().key // para mag ka unique Id ito ginamit ko push().key
                    val userData = UserData(id, username, password)
                    databaseReference.child(id!!).setValue(userData) // kaya yung ID is a child kasi para unique from each other
                    // dito nag intent ako papunta log in pag successful and yung dalawa taost sa baba validation lang
                    Toast.makeText(this@SignupActivity, "Signup Succesful", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@SignupActivity, LoginActivity::class.java))
                    finish()
                }else {
                    Toast.makeText(this@SignupActivity, "User already exists", Toast.LENGTH_SHORT).show()
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@SignupActivity, "Database Error: ${databaseError.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
