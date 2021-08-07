package com.tami.shopping.data.source

import com.tami.shopping.data.remote.FakeShoppingApi
import com.tami.shopping.data.remote.ShoppingApi
import org.junit.Before

class HomeDataSourceImplTest {
    private val shoppingApi: ShoppingApi = FakeShoppingApi()
    lateinit var homeDataSource: HomeDataSource

    @Before
    fun init() {
        homeDataSource = HomeDataSourceImpl(shoppingApi)
    }
}