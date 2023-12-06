package hr.fabolicodi.firebasevjezba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.SAVED_STATE_REGISTRY_OWNER_KEY
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import hr.fabolicodi.firebasevjezba.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val database:DatabaseReference=FirebaseDatabase.getInstance("https://bluurb-60a55-default-rtdb.europe-west1.firebasedatabase.app/").getReference("teskt")
    lateinit var binding:ActivityMainBinding
    val textlist=ArrayList<vatrenabaze>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                try{

                val a:List<vatrenabaze> = snapshot.children.map{datasnapshot->datasnapshot.getValue(vatrenabaze::class.java)!!}
                textlist.addAll(a)

                }catch(_:Exception  ){}
                binding.lista.apply{
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    adapter = TextAdapter(textlist,this@MainActivity)
                    {position->
                        Toast.makeText(this@MainActivity,"pozicija je $position",Toast.LENGTH_LONG).show()
                    }
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")

        }
    })

}}