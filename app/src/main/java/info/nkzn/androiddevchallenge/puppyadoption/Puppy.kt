package info.nkzn.androiddevchallenge.puppyadoption

data class Puppy(
    val id: String,
    val name: String,
    val monthsOfAge: Int,
    val iconId: Int,
)

val puppies = listOf(
    Puppy("1", "Shiba Inu", 8, R.drawable.dog_shibainu_brown),
    Puppy("2", "Rottweiler", 3, R.drawable.dog_rottweiler),
    Puppy("3", "Akita Inu", 4, R.drawable.dog_akitainu),
)