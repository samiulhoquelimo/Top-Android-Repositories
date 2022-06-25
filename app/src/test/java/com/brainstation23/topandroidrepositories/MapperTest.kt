package com.brainstation23.topandroidrepositories

import com.brainstation23.topandroidrepositories.data.network.response.model.Item
import com.brainstation23.topandroidrepositories.data.network.response.model.Owner
import com.brainstation23.topandroidrepositories.data.network.response.model.toGitRepository
import com.brainstation23.topandroidrepositories.utils.extension.toOffsetDateTime
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class MapperTest {

    @Test
    fun `mapper Item to GitRepository with complete data`() {
        val item = buildItem()
        val repository = item.toGitRepository()

        assertThat(repository.id == id).isTrue()
        assertThat(repository.name == name).isTrue()
        assertThat(repository.date == date.toOffsetDateTime()).isTrue()
        assertThat(repository.star == star).isTrue()
        assertThat(repository.description == description).isTrue()
        assertThat(repository.image == url).isTrue()
    }

    @Test
    fun `mapper Item to GitRepository with incomplete data`() {
        val item = buildNullItem()
        val repository = item.toGitRepository()

        assertThat(repository.id == null).isTrue()
        assertThat(repository.name == null).isTrue()
        assertThat(repository.date == null).isTrue()
        assertThat(repository.star == null).isTrue()
        assertThat(repository.description == null).isTrue()
        assertThat(repository.image == null).isTrue()
    }

    private fun buildOwner(): Owner {
        return Owner(
            avatar_url = url
        )
    }

    private fun buildItem(): Item {
        return Item(
            id = id,
            full_name = name,
            owner = buildOwner(),
            description = description,
            updated_at = date,
            stargazers_count = star
        )
    }

    private fun buildNullItem(): Item {
        return Item(
            id = null,
            full_name = null,
            owner = null,
            description = null,
            updated_at = null,
            stargazers_count = null
        )
    }

    companion object {
        private const val id = 321360
        private const val name = "uavana/android"
        private const val description = "Misc Android stuff"
        private const val date = "2022-06-16T11:51:38Z"
        private const val url = "https://avatars.githubusercontent.com/u/23095877?v=4"
        private const val star = 60
    }
}