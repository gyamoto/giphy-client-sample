package com.gyamoto.db

import android.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import kotlin.test.assertEquals

class RepositoryTest {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    private lateinit var mockStore: Store<String>

    private lateinit var store: Repository<String>

    @Before
    fun setup() {

        mockStore = object : Store<String> {
            override var item: String? = null
        }

        store = Repository(mockStore)
    }

    @Test
    fun `初期値はNull`() {
        assertEquals(null, store.value)
    }

    @Test
    fun `Updateすると設定される`() {
        store.update("Yo")
        assertEquals("Yo", store.value)
    }

    @Test
    fun `Updateは上書きされる`() {
        store.update("Yo")
        store.update("Ho!")
        assertEquals("Ho!", store.value)
    }

    @Test
    fun `ClearするとNullになる`() {
        store.update("Yo")
        store.clear()
        assertEquals(null, store.value)
    }
}
