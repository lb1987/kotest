package com.sksamuel.kotest.extensions

import io.kotest.assertions.fail
import io.kotest.core.Tag
import io.kotest.core.spec.Spec
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.extensions.RuntimeTagExtension

class RuntimeTagExtensionTest : StringSpec() {

   object MyRuntimeExcludedTag : Tag()

   init {

      "Test marked with a runtime excluded tag".config(tags = setOf(MyRuntimeExcludedTag)) {
         fail("Should never execute (configured to be excluded in beforeSpec)")
      }
   }

   override fun beforeSpec(spec: Spec) {
      RuntimeTagExtension.excluded += MyRuntimeExcludedTag
   }
}
