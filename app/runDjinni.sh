#!/bin/bash

~/tmp/djinni/src/run \
   --java-out src/main/java/ch/fork/djinnisample/djinni_generated \
   --java-package ch.fork.djinnisample.djinni_generated \
   --ident-java-field mFooBar \
   --cpp-out src/main/jni/djinni_generated/cpp \
   --cpp-namespace Fibonacci \
   --jni-namespace Fibonacci \
   --jni-out src/main/jni/djinni_generated/jni \
   --ident-jni-class NativeFooBar \
   --ident-jni-file NativeFooBar \
   --idl fibonacci.djinni