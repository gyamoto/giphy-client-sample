package com.gyamoto.api

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.instance

class ApiBuilder {

    companion object {

        private val kodein = Kodein {
            import(sourceModule)
            import(buildTypeModule)
        }

        fun build(): Api {

            val source: SourceType = kodein.instance()
            val buildType: BuildTypeConfig = kodein.instance()

            return source.build(buildType)
        }

    }
}
