package com.rylderoliveira.preferences

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object PersonSerializer : Serializer<Person> {
    override val defaultValue: Person = Person.newBuilder()
        .setAge(0)
        .setName("Name default")
        .build()

    override suspend fun readFrom(input: InputStream): Person {
        try {
            return Person.parseFrom(input)
        } catch (e: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto", e)
        }
    }

    override suspend fun writeTo(t: Person, output: OutputStream) {
        t.writeTo(output)
    }
}
