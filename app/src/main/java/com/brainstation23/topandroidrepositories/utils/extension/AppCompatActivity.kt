package com.brainstation23.topandroidrepositories.utils.extension

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.brainstation23.topandroidrepositories.BuildConfig
import com.brainstation23.topandroidrepositories.data.database.repository.git_repository.GitRepository
import com.brainstation23.topandroidrepositories.data.network.response.model.Item
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.view.model.SortType
import java.text.SimpleDateFormat
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

private const val SERVER_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"
private const val LOCAL_FORMAT = "MM-dd-yy HH:ss" // Format: month-day-year hour:seconds

fun OffsetDateTime.toDateString(): String {
    val formatter = DateTimeFormatter.ofPattern(LOCAL_FORMAT)
    return formatter.format(this)
}

fun String.toOffsetDateTime(): OffsetDateTime? = try {
    val format = SimpleDateFormat(SERVER_FORMAT)
    val date = format.parse(this)
    date?.toInstant()?.atOffset(ZoneOffset.UTC)
} catch (e: Exception) {
    e.printStackTrace()
    null
}

fun Item.toGitRepository(): GitRepository {
    val url = this.owner?.avatar_url
    return GitRepository(
        id = this.id,
        name = this.full_name,
        description = this.description,
        date = this.updated_at?.toOffsetDateTime(),
        image = url,
        star = this.stargazers_count
    )
}

fun List<Item>?.mapList(): List<GitRepository> {
    val arrayList = ArrayList<GitRepository>()
    this?.forEach { model -> arrayList.add(model.toGitRepository()) }
    return arrayList
}

inline fun debugMode(block: () -> Unit) {
    if (BuildConfig.DEBUG) {
        block()
    }
}

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

fun AppCompatActivity.replaceFragment(
    fragment: Fragment,
    frameId: Int,
    addToStack: Boolean = false,
    clearBackStack: Boolean = true
) {
    supportFragmentManager.inTransaction {
        if (clearBackStack && supportFragmentManager.backStackEntryCount > 0) {
            val first = supportFragmentManager.getBackStackEntryAt(0)
            supportFragmentManager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
        if (addToStack) {
            replace(frameId, fragment, fragment.javaClass.simpleName)
                .addToBackStack(fragment.javaClass.simpleName)
        } else {
            replace(frameId, fragment, fragment.javaClass.simpleName)
        }
    }
}

fun Int.toSortType() = when (this) {
    SortType.DateAsc.type -> SortType.DateAsc
    SortType.DateDesc.type -> SortType.DateDesc
    SortType.StarAsc.type -> SortType.StarAsc
    SortType.StarDesc.type -> SortType.StarDesc
    else -> SortType.None
}