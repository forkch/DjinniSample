//
// Copyright 2014 Dropbox, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

// This provides a minimal JNI_OnLoad and JNI_OnUnload implementation - include it if your
// app doesn't use JNI except through Djinni.

#include "djinni_support.hpp"

#if defined(__arm__)
#if defined(__ARM_ARCH_7A__)
  #if defined(__ARM_NEON__)
    #if defined(__ARM_PCS_VFP)
      #define ABI "armeabi-v7a/NEON (hard-float)"
    #else
      #define ABI "armeabi-v7a/NEON"
    #endif
  #else
    #if defined(__ARM_PCS_VFP)
      #define ABI "armeabi-v7a (hard-float)"
    #else
      #define ABI "armeabi-v7a"
    #endif
  #endif
#else
 #define ABI "armeabi"
#endif
#elif defined(__i386__)
#define ABI "x86"
#elif defined(__x86_64__)
#define ABI "x86_64"
#elif defined(__mips64)  /* mips64el-* toolchain defines __mips__ too */
#define ABI "mips64"
#elif defined(__mips__)
#define ABI "mips"
#elif defined(__aarch64__)
#define ABI "arm64-v8a"
#else
#define ABI "unknown"
#endif

// Called when library is loaded by the first class which uses it.
CJNIEXPORT jint JNICALL JNI_OnLoad(JavaVM * jvm, void * /*reserved*/) {
    djinni::jniInit(jvm);
    return JNI_VERSION_1_6;
}

// (Potentially) called when library is about to be unloaded.
CJNIEXPORT void JNICALL JNI_OnUnload(JavaVM * /*jvm*/, void * /*reserved*/) {
    djinni::jniShutdown();
}
