import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.firebase.firestore.model.DocumentKey
import com.myself223.card.data.room.converter.Converter
import com.myself223.card.data.room.models.CategoryModel
import java.io.Serializable

data class FireStoreModel (
    var id: String = "",
    var name:String = "",
    var image:String = ""
)