package com.giphy

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.singleton

/**
 * Created by kyamamoto on 2018/01/22.
 */
val sourceModule = Kodein.Module {

    bind<SourceType>() with singleton { MockApi() }
}
