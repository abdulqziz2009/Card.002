import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myself223.card.data.room.models.CategoryModel
import com.myself223.card.databinding.InCategoryBinding

class CategoryAdapter(private val click2: Result) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private val list = ArrayList<CategoryModel>()

    fun setList(list: List<CategoryModel>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    inner class CategoryViewHolder(private val binding: InCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun OnBind(position: Int) {
            binding.txtName.text = list[position].name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            InCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size


    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.OnBind(position)
        holder.itemView.setOnClickListener {
            click2.OnClick2(list, position)
        }

    }
    interface Result {
        fun OnClick2(list: List<CategoryModel>, pos: Int)
    }
}





