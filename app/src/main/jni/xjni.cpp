//
// Created by will on 19-2-19.
//

#define LOG_TAG "XJni-JNI"

#include "jni.h"
#include <android/log.h>
#include <iostream>
#include "Person.pb.h"
#include "NestedEntry.pb.h"


#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG,LOG_TAG ,__VA_ARGS__) // 定义LOGD类型
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,LOG_TAG ,__VA_ARGS__) // 定义LOGI类型
#define LOGW(...) __android_log_print(ANDROID_LOG_WARN,LOG_TAG ,__VA_ARGS__) // 定义LOGW类型
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,LOG_TAG ,__VA_ARGS__) // 定义LOGE类型
#define LOGF(...) __android_log_print(ANDROID_LOG_FATAL,LOG_TAG ,__VA_ARGS__) // 定义LOGF类型


static const char* const kClassPathName = "com/segway/prototest/XJni";


JNIEXPORT jstring JNICALL stringFromJNI(JNIEnv * env,jobject){

    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());


}

JNIEXPORT jint JNICALL writeProto_native(JNIEnv* env,jclass,jbyteArray protoData,jint index){

    entry::Person person;
    char* chars = NULL;
    jbyte * bytes;
    bytes = env->GetByteArrayElements(protoData,0);
    int chars_length = env->GetArrayLength(protoData);
    chars = new char[chars_length + 1];
    memset(chars,0,chars_length + 1);
    memcpy(chars, bytes, chars_length);
    person.ParseFromArray(chars,chars_length);
    LOGD("writeProto_native name:%s,id:%d,email:%s",person.name().c_str(),person.id(),person.email().c_str());
    return index;
}

JNIEXPORT jint JNICALL writePerson_native(JNIEnv* env,jclass javaClass,jobject person,jint index){
    jclass jcls = env->GetObjectClass(person);
    jmethodID getName = env->GetMethodID(jcls,"getName","()Ljava/lang/String;");
    jstring jname = (jstring)env->CallObjectMethod(person,getName);
    char * name = (char*) env->GetStringUTFChars(jname,NULL);
    jmethodID getEmail = env->GetMethodID(jcls,"getEmail","()Ljava/lang/String;");
    jstring jemail = (jstring)env->CallObjectMethod(person,getEmail);
    char * email = (char*) env->GetStringUTFChars(jemail,NULL);
    jmethodID getId = env->GetMethodID(jcls,"getId","()I");
    jint jId = env->CallIntMethod(person,getId);

    LOGD("writePerson_native name:%s,id:%d,email:%s",name,jId,email);
    return index;
}

JNIEXPORT jobject JNICALL readPerson_native(JNIEnv* env,jclass javaClass,jint index){

    jobject person;
    jclass class_person = env->FindClass("com/segway/prototest/entry/Person");
    jmethodID method_constructor = env->GetMethodID(class_person,"<init>","()V");
    person = env->NewObject(class_person,method_constructor);
    jmethodID method_name = env->GetMethodID(class_person,"setName","(Ljava/lang/String;)V");
    jstring name = env->NewStringUTF("Java");
    jmethodID method_email = env->GetMethodID(class_person,"setEmail","(Ljava/lang/String;)V");
    jstring email = env->NewStringUTF("Hello,Wrold!");
    jmethodID  method_id = env->GetMethodID(class_person,"setId","(I)V");

    env->CallVoidMethod(person,method_name,name);
    env->CallVoidMethod(person,method_email,email);
    env->CallVoidMethod(person,method_id,index);
    env->DeleteLocalRef(name);
    env->DeleteLocalRef(email);
    return person;

}


JNIEXPORT jbyteArray JNICALL readProto_native(JNIEnv* env,jclass ,jint index){
    entry::Person person;
    person.set_name("Java");
    person.set_email("Hello,World!");
    person.set_id(index);
    int size = person.ByteSize();
    char* buf = new char[size];
    person.SerializeToArray(buf,size);
    jbyteArray  jarray = env->NewByteArray(size);
    env->SetByteArrayRegion(jarray,0,size,(jbyte*)buf);
    delete[] buf;
    return jarray;
}

JNIEXPORT jint JNICALL writeNested_native(JNIEnv* env,jclass ,jobject nested,jint index){
    jclass jNestedCls = env->GetObjectClass(nested);
    jmethodID  getPerson = env->GetMethodID(jNestedCls,"getPerson","()Lcom/segway/prototest/entry/Person;");
    jobject jPerson = env->CallObjectMethod(nested,getPerson);
    jclass jPersonCls = env->GetObjectClass(jPerson);
    jmethodID  getName = env->GetMethodID(jPersonCls,"getName","()Ljava/lang/String;");
    jstring jname = (jstring)env->CallObjectMethod(jPerson,getName);
    char* name = (char *)env->GetStringUTFChars(jname,NULL);
    LOGD("writeNested_native name is %s",name);
    return index;
}

JNIEXPORT jint JNICALL writeNestedProto_native(JNIEnv* env,jclass ,jbyteArray protoData,jint index){
    entry::NestedEntry nestedEntry;
    char* chars = NULL;
    jbyte * bytes;
    bytes = env->GetByteArrayElements(protoData,0);
    int chars_length = env->GetArrayLength(protoData);
    chars = new char[chars_length + 1];
    memset(chars,0,chars_length + 1);
    memcpy(chars, bytes, chars_length);
    nestedEntry.ParseFromArray(chars,chars_length);
    LOGD("writeNestedProto_native name is %s",nestedEntry.person().name().c_str());
    return index;
}

JNIEXPORT jbyteArray JNICALL readNestedProto_native(JNIEnv* env,jclass ,jint index){


    entry::NestedEntry nestedEntry;
    double d = 1;
    float f = 1;
    nestedEntry.set_doubleobj(d);
    nestedEntry.set_floatobj(f);
    nestedEntry.set_int32obj(1);
    nestedEntry.set_int64obj(1L);
    nestedEntry.set_boolobj(true);
    nestedEntry.set_strobj("Hello");
    entry::Person * person = nestedEntry.mutable_person();
    person->set_name("Java");
    person->set_email("Hello,World!");
    person->set_id(index);;
    int size = nestedEntry.ByteSize();
    char* buf = new char[size];
    nestedEntry.SerializeToArray(buf,size);
    jbyteArray  jarray = env->NewByteArray(size);
    env->SetByteArrayRegion(jarray,0,size,(jbyte*)buf);
    delete[] buf;
    return jarray;
}

JNIEXPORT jobject JNICALL readNestedEntry_native(JNIEnv* env,jclass javaClass,jint index){

    jobject person;
    jclass class_person = env->FindClass("com/segway/prototest/entry/Person");
    jmethodID method_constructor = env->GetMethodID(class_person,"<init>","()V");
    person = env->NewObject(class_person,method_constructor);
    jmethodID method_name = env->GetMethodID(class_person,"setName","(Ljava/lang/String;)V");
    jstring name = env->NewStringUTF("Java");
    jmethodID method_email = env->GetMethodID(class_person,"setEmail","(Ljava/lang/String;)V");
    jstring email = env->NewStringUTF("Hello,Wrold!");
    jmethodID  method_id = env->GetMethodID(class_person,"setId","(I)V");

    env->CallVoidMethod(person,method_name,name);
    env->CallVoidMethod(person,method_email,email);
    env->CallVoidMethod(person,method_id,index);
    env->DeleteLocalRef(name);
    env->DeleteLocalRef(email);
    jobject nested;
    jclass class_nested = env->FindClass("com/segway/prototest/entry/NestedEntry");
    jmethodID  nested_constructor = env->GetMethodID(class_nested,"<init>","()V");
    nested = env->NewObject(class_nested,nested_constructor);
    jmethodID method_set_person = env->GetMethodID(class_nested,"setPerson","(Lcom/segway/prototest/entry/Person;)V");
    env->CallVoidMethod(nested,method_set_person,person);
    jmethodID setStrObj = env->GetMethodID(class_nested,"setStrObj","(Ljava/lang/String;)V");
    jstring strObj = env->NewStringUTF("Hello");
    env->CallVoidMethod(nested,setStrObj,strObj);
    jmethodID setInt32Obj = env->GetMethodID(class_nested,"setInt32Obj","(I)V");
    env->CallVoidMethod(nested,setInt32Obj,1);
    jmethodID setInt64Obj = env->GetMethodID(class_nested,"setInt64Obj","(J)V");
    env->CallVoidMethod(nested,setInt64Obj,1L);
    jmethodID setFloatObj = env->GetMethodID(class_nested,"setFloatObj","(F)V");
    float f=1;
    double d=1;
    env->CallVoidMethod(nested,setFloatObj,f);
    jmethodID setDoubleObj = env->GetMethodID(class_nested,"setDoubleObj","(D)V");
    env->CallVoidMethod(nested,setDoubleObj,d);
    jmethodID setBoolObj = env->GetMethodID(class_nested,"setBoolObj","(Z)V");
    env->CallVoidMethod(nested,setBoolObj,true);

    return nested;

}







static JNINativeMethod gMethods[] ={
        {"getStr","()Ljava/lang/String;",(void*)stringFromJNI},
        {"writeProto","([BI)I",(jint*)writeProto_native},
        {"writePerson","(Lcom/segway/prototest/entry/Person;I)I",(jint*)writePerson_native},
        {"readPerson","(I)Lcom/segway/prototest/entry/Person;",(jobject*)readPerson_native},
        {"readProto","(I)[B",(jbyteArray*)readProto_native},
        {"writeNestedEntry","(Lcom/segway/prototest/entry/NestedEntry;I)I",(jint*)writeNested_native},
        {"writeNestedProto","([BI)I",(jint*)writeNestedProto_native},
        {"readNestedProto","(I)[B",(jbyteArray*)readNestedProto_native},
        {"readNestedEntry","(I)Lcom/segway/prototest/entry/NestedEntry;",(jobject*)readNestedEntry_native}
};

jint JNI_OnLoad(JavaVM* vm,void* reserved)
{
    LOGD("JNI_OnLoad");
    JNIEnv * env = NULL;
    vm->GetEnv((void **)&env,JNI_VERSION_1_6);
    env->RegisterNatives(env->FindClass(kClassPathName),gMethods, sizeof(gMethods)/sizeof(JNINativeMethod));
    return JNI_VERSION_1_6;
}
