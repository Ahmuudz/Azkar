import com.google.gson.annotations.SerializedName

data class AzkarResponse(
    @SerializedName("title")
    val title: String,

    @SerializedName("content")
    val content: List<AzkarContent>
)

data class AzkarContent(
    @SerializedName("zekr")
    val zekr: String,

    @SerializedName("repeat")
    val repeat: Int,

    @SerializedName("bless")
    val bless: String
)