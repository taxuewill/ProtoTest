// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: NestedEntry.proto

#include "NestedEntry.pb.h"

#include <algorithm>

#include <google/protobuf/stubs/common.h>
#include <google/protobuf/stubs/port.h>
#include <google/protobuf/io/coded_stream.h>
#include <google/protobuf/wire_format_lite_inl.h>
#include <google/protobuf/descriptor.h>
#include <google/protobuf/generated_message_reflection.h>
#include <google/protobuf/reflection_ops.h>
#include <google/protobuf/wire_format.h>
// This is a temporary google only hack
#ifdef GOOGLE_PROTOBUF_ENFORCE_UNIQUENESS
#include "third_party/protobuf/version.h"
#endif
// @@protoc_insertion_point(includes)

namespace protobuf_Person_2eproto {
extern PROTOBUF_INTERNAL_EXPORT_protobuf_Person_2eproto ::google::protobuf::internal::SCCInfo<0> scc_info_Person;
}  // namespace protobuf_Person_2eproto
namespace entry {
class NestedEntryDefaultTypeInternal {
 public:
  ::google::protobuf::internal::ExplicitlyConstructed<NestedEntry>
      _instance;
} _NestedEntry_default_instance_;
}  // namespace entry
namespace protobuf_NestedEntry_2eproto {
static void InitDefaultsNestedEntry() {
  GOOGLE_PROTOBUF_VERIFY_VERSION;

  ::entry::NestedEntry::_i_give_permission_to_break_this_code_default_strobj_.DefaultConstruct();
  *::entry::NestedEntry::_i_give_permission_to_break_this_code_default_strobj_.get_mutable() = ::std::string("hello", 5);
  ::google::protobuf::internal::OnShutdownDestroyString(
      ::entry::NestedEntry::_i_give_permission_to_break_this_code_default_strobj_.get_mutable());
  {
    void* ptr = &::entry::_NestedEntry_default_instance_;
    new (ptr) ::entry::NestedEntry();
    ::google::protobuf::internal::OnShutdownDestroyMessage(ptr);
  }
  ::entry::NestedEntry::InitAsDefaultInstance();
}

::google::protobuf::internal::SCCInfo<1> scc_info_NestedEntry =
    {{ATOMIC_VAR_INIT(::google::protobuf::internal::SCCInfoBase::kUninitialized), 1, InitDefaultsNestedEntry}, {
      &protobuf_Person_2eproto::scc_info_Person.base,}};

void InitDefaults() {
  ::google::protobuf::internal::InitSCC(&scc_info_NestedEntry.base);
}

::google::protobuf::Metadata file_level_metadata[1];

const ::google::protobuf::uint32 TableStruct::offsets[] GOOGLE_PROTOBUF_ATTRIBUTE_SECTION_VARIABLE(protodesc_cold) = {
  GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(::entry::NestedEntry, _has_bits_),
  GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(::entry::NestedEntry, _internal_metadata_),
  ~0u,  // no _extensions_
  ~0u,  // no _oneof_case_
  ~0u,  // no _weak_field_map_
  GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(::entry::NestedEntry, strobj_),
  GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(::entry::NestedEntry, int32obj_),
  GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(::entry::NestedEntry, int64obj_),
  GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(::entry::NestedEntry, floatobj_),
  GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(::entry::NestedEntry, doubleobj_),
  GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(::entry::NestedEntry, boolobj_),
  GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(::entry::NestedEntry, bytesobj_),
  GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(::entry::NestedEntry, person_),
  0,
  4,
  3,
  5,
  6,
  7,
  1,
  2,
};
static const ::google::protobuf::internal::MigrationSchema schemas[] GOOGLE_PROTOBUF_ATTRIBUTE_SECTION_VARIABLE(protodesc_cold) = {
  { 0, 13, sizeof(::entry::NestedEntry)},
};

static ::google::protobuf::Message const * const file_default_instances[] = {
  reinterpret_cast<const ::google::protobuf::Message*>(&::entry::_NestedEntry_default_instance_),
};

void protobuf_AssignDescriptors() {
  AddDescriptors();
  AssignDescriptors(
      "NestedEntry.proto", schemas, file_default_instances, TableStruct::offsets,
      file_level_metadata, NULL, NULL);
}

void protobuf_AssignDescriptorsOnce() {
  static ::google::protobuf::internal::once_flag once;
  ::google::protobuf::internal::call_once(once, protobuf_AssignDescriptors);
}

void protobuf_RegisterTypes(const ::std::string&) GOOGLE_PROTOBUF_ATTRIBUTE_COLD;
void protobuf_RegisterTypes(const ::std::string&) {
  protobuf_AssignDescriptorsOnce();
  ::google::protobuf::internal::RegisterAllTypes(file_level_metadata, 1);
}

void AddDescriptorsImpl() {
  InitDefaults();
  static const char descriptor[] GOOGLE_PROTOBUF_ATTRIBUTE_SECTION_VARIABLE(protodesc_cold) = {
      "\n\021NestedEntry.proto\022\005entry\032\014Person.proto"
      "\"\257\001\n\013NestedEntry\022\025\n\006strObj\030\001 \002(\t:\005hello\022"
      "\020\n\010int32Obj\030\002 \001(\005\022\020\n\010int64Obj\030\003 \001(\003\022\020\n\010f"
      "loatObj\030\004 \001(\002\022\021\n\tdoubleObj\030\005 \001(\001\022\017\n\007bool"
      "Obj\030\006 \001(\010\022\020\n\010bytesObj\030\007 \001(\014\022\035\n\006person\030\010 "
      "\001(\0132\r.entry.PersonB0\n\032com.segway.protote"
      "st.entryB\020NestedEntryProtoH\001"
  };
  ::google::protobuf::DescriptorPool::InternalAddGeneratedFile(
      descriptor, 268);
  ::google::protobuf::MessageFactory::InternalRegisterGeneratedFile(
    "NestedEntry.proto", &protobuf_RegisterTypes);
  ::protobuf_Person_2eproto::AddDescriptors();
}

void AddDescriptors() {
  static ::google::protobuf::internal::once_flag once;
  ::google::protobuf::internal::call_once(once, AddDescriptorsImpl);
}
// Force AddDescriptors() to be called at dynamic initialization time.
struct StaticDescriptorInitializer {
  StaticDescriptorInitializer() {
    AddDescriptors();
  }
} static_descriptor_initializer;
}  // namespace protobuf_NestedEntry_2eproto
namespace entry {

// ===================================================================

void NestedEntry::InitAsDefaultInstance() {
  ::entry::_NestedEntry_default_instance_._instance.get_mutable()->person_ = const_cast< ::entry::Person*>(
      ::entry::Person::internal_default_instance());
}
::google::protobuf::internal::ExplicitlyConstructed<::std::string> NestedEntry::_i_give_permission_to_break_this_code_default_strobj_;
void NestedEntry::clear_person() {
  if (person_ != NULL) person_->Clear();
  clear_has_person();
}
#if !defined(_MSC_VER) || _MSC_VER >= 1900
const int NestedEntry::kStrObjFieldNumber;
const int NestedEntry::kInt32ObjFieldNumber;
const int NestedEntry::kInt64ObjFieldNumber;
const int NestedEntry::kFloatObjFieldNumber;
const int NestedEntry::kDoubleObjFieldNumber;
const int NestedEntry::kBoolObjFieldNumber;
const int NestedEntry::kBytesObjFieldNumber;
const int NestedEntry::kPersonFieldNumber;
#endif  // !defined(_MSC_VER) || _MSC_VER >= 1900

NestedEntry::NestedEntry()
  : ::google::protobuf::Message(), _internal_metadata_(NULL) {
  ::google::protobuf::internal::InitSCC(
      &protobuf_NestedEntry_2eproto::scc_info_NestedEntry.base);
  SharedCtor();
  // @@protoc_insertion_point(constructor:entry.NestedEntry)
}
NestedEntry::NestedEntry(const NestedEntry& from)
  : ::google::protobuf::Message(),
      _internal_metadata_(NULL),
      _has_bits_(from._has_bits_) {
  _internal_metadata_.MergeFrom(from._internal_metadata_);
  strobj_.UnsafeSetDefault(&::entry::NestedEntry::_i_give_permission_to_break_this_code_default_strobj_.get());
  if (from.has_strobj()) {
    strobj_.AssignWithDefault(&::entry::NestedEntry::_i_give_permission_to_break_this_code_default_strobj_.get(), from.strobj_);
  }
  bytesobj_.UnsafeSetDefault(&::google::protobuf::internal::GetEmptyStringAlreadyInited());
  if (from.has_bytesobj()) {
    bytesobj_.AssignWithDefault(&::google::protobuf::internal::GetEmptyStringAlreadyInited(), from.bytesobj_);
  }
  if (from.has_person()) {
    person_ = new ::entry::Person(*from.person_);
  } else {
    person_ = NULL;
  }
  ::memcpy(&int64obj_, &from.int64obj_,
    static_cast<size_t>(reinterpret_cast<char*>(&boolobj_) -
    reinterpret_cast<char*>(&int64obj_)) + sizeof(boolobj_));
  // @@protoc_insertion_point(copy_constructor:entry.NestedEntry)
}

void NestedEntry::SharedCtor() {
  strobj_.UnsafeSetDefault(&::entry::NestedEntry::_i_give_permission_to_break_this_code_default_strobj_.get());
  bytesobj_.UnsafeSetDefault(&::google::protobuf::internal::GetEmptyStringAlreadyInited());
  ::memset(&person_, 0, static_cast<size_t>(
      reinterpret_cast<char*>(&boolobj_) -
      reinterpret_cast<char*>(&person_)) + sizeof(boolobj_));
}

NestedEntry::~NestedEntry() {
  // @@protoc_insertion_point(destructor:entry.NestedEntry)
  SharedDtor();
}

void NestedEntry::SharedDtor() {
  strobj_.DestroyNoArena(&::entry::NestedEntry::_i_give_permission_to_break_this_code_default_strobj_.get());
  bytesobj_.DestroyNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited());
  if (this != internal_default_instance()) delete person_;
}

void NestedEntry::SetCachedSize(int size) const {
  _cached_size_.Set(size);
}
const ::google::protobuf::Descriptor* NestedEntry::descriptor() {
  ::protobuf_NestedEntry_2eproto::protobuf_AssignDescriptorsOnce();
  return ::protobuf_NestedEntry_2eproto::file_level_metadata[kIndexInFileMessages].descriptor;
}

const NestedEntry& NestedEntry::default_instance() {
  ::google::protobuf::internal::InitSCC(&protobuf_NestedEntry_2eproto::scc_info_NestedEntry.base);
  return *internal_default_instance();
}


void NestedEntry::Clear() {
// @@protoc_insertion_point(message_clear_start:entry.NestedEntry)
  ::google::protobuf::uint32 cached_has_bits = 0;
  // Prevent compiler warnings about cached_has_bits being unused
  (void) cached_has_bits;

  cached_has_bits = _has_bits_[0];
  if (cached_has_bits & 7u) {
    if (cached_has_bits & 0x00000001u) {
      strobj_.UnsafeMutablePointer()->assign(*&::entry::NestedEntry::_i_give_permission_to_break_this_code_default_strobj_.get());
    }
    if (cached_has_bits & 0x00000002u) {
      bytesobj_.ClearNonDefaultToEmptyNoArena();
    }
    if (cached_has_bits & 0x00000004u) {
      GOOGLE_DCHECK(person_ != NULL);
      person_->Clear();
    }
  }
  if (cached_has_bits & 248u) {
    ::memset(&int64obj_, 0, static_cast<size_t>(
        reinterpret_cast<char*>(&boolobj_) -
        reinterpret_cast<char*>(&int64obj_)) + sizeof(boolobj_));
  }
  _has_bits_.Clear();
  _internal_metadata_.Clear();
}

bool NestedEntry::MergePartialFromCodedStream(
    ::google::protobuf::io::CodedInputStream* input) {
#define DO_(EXPRESSION) if (!GOOGLE_PREDICT_TRUE(EXPRESSION)) goto failure
  ::google::protobuf::uint32 tag;
  // @@protoc_insertion_point(parse_start:entry.NestedEntry)
  for (;;) {
    ::std::pair<::google::protobuf::uint32, bool> p = input->ReadTagWithCutoffNoLastTag(127u);
    tag = p.first;
    if (!p.second) goto handle_unusual;
    switch (::google::protobuf::internal::WireFormatLite::GetTagFieldNumber(tag)) {
      // required string strObj = 1 [default = "hello"];
      case 1: {
        if (static_cast< ::google::protobuf::uint8>(tag) ==
            static_cast< ::google::protobuf::uint8>(10u /* 10 & 0xFF */)) {
          DO_(::google::protobuf::internal::WireFormatLite::ReadString(
                input, this->mutable_strobj()));
          ::google::protobuf::internal::WireFormat::VerifyUTF8StringNamedField(
            this->strobj().data(), static_cast<int>(this->strobj().length()),
            ::google::protobuf::internal::WireFormat::PARSE,
            "entry.NestedEntry.strObj");
        } else {
          goto handle_unusual;
        }
        break;
      }

      // optional int32 int32Obj = 2;
      case 2: {
        if (static_cast< ::google::protobuf::uint8>(tag) ==
            static_cast< ::google::protobuf::uint8>(16u /* 16 & 0xFF */)) {
          set_has_int32obj();
          DO_((::google::protobuf::internal::WireFormatLite::ReadPrimitive<
                   ::google::protobuf::int32, ::google::protobuf::internal::WireFormatLite::TYPE_INT32>(
                 input, &int32obj_)));
        } else {
          goto handle_unusual;
        }
        break;
      }

      // optional int64 int64Obj = 3;
      case 3: {
        if (static_cast< ::google::protobuf::uint8>(tag) ==
            static_cast< ::google::protobuf::uint8>(24u /* 24 & 0xFF */)) {
          set_has_int64obj();
          DO_((::google::protobuf::internal::WireFormatLite::ReadPrimitive<
                   ::google::protobuf::int64, ::google::protobuf::internal::WireFormatLite::TYPE_INT64>(
                 input, &int64obj_)));
        } else {
          goto handle_unusual;
        }
        break;
      }

      // optional float floatObj = 4;
      case 4: {
        if (static_cast< ::google::protobuf::uint8>(tag) ==
            static_cast< ::google::protobuf::uint8>(37u /* 37 & 0xFF */)) {
          set_has_floatobj();
          DO_((::google::protobuf::internal::WireFormatLite::ReadPrimitive<
                   float, ::google::protobuf::internal::WireFormatLite::TYPE_FLOAT>(
                 input, &floatobj_)));
        } else {
          goto handle_unusual;
        }
        break;
      }

      // optional double doubleObj = 5;
      case 5: {
        if (static_cast< ::google::protobuf::uint8>(tag) ==
            static_cast< ::google::protobuf::uint8>(41u /* 41 & 0xFF */)) {
          set_has_doubleobj();
          DO_((::google::protobuf::internal::WireFormatLite::ReadPrimitive<
                   double, ::google::protobuf::internal::WireFormatLite::TYPE_DOUBLE>(
                 input, &doubleobj_)));
        } else {
          goto handle_unusual;
        }
        break;
      }

      // optional bool boolObj = 6;
      case 6: {
        if (static_cast< ::google::protobuf::uint8>(tag) ==
            static_cast< ::google::protobuf::uint8>(48u /* 48 & 0xFF */)) {
          set_has_boolobj();
          DO_((::google::protobuf::internal::WireFormatLite::ReadPrimitive<
                   bool, ::google::protobuf::internal::WireFormatLite::TYPE_BOOL>(
                 input, &boolobj_)));
        } else {
          goto handle_unusual;
        }
        break;
      }

      // optional bytes bytesObj = 7;
      case 7: {
        if (static_cast< ::google::protobuf::uint8>(tag) ==
            static_cast< ::google::protobuf::uint8>(58u /* 58 & 0xFF */)) {
          DO_(::google::protobuf::internal::WireFormatLite::ReadBytes(
                input, this->mutable_bytesobj()));
        } else {
          goto handle_unusual;
        }
        break;
      }

      // optional .entry.Person person = 8;
      case 8: {
        if (static_cast< ::google::protobuf::uint8>(tag) ==
            static_cast< ::google::protobuf::uint8>(66u /* 66 & 0xFF */)) {
          DO_(::google::protobuf::internal::WireFormatLite::ReadMessage(
               input, mutable_person()));
        } else {
          goto handle_unusual;
        }
        break;
      }

      default: {
      handle_unusual:
        if (tag == 0) {
          goto success;
        }
        DO_(::google::protobuf::internal::WireFormat::SkipField(
              input, tag, _internal_metadata_.mutable_unknown_fields()));
        break;
      }
    }
  }
success:
  // @@protoc_insertion_point(parse_success:entry.NestedEntry)
  return true;
failure:
  // @@protoc_insertion_point(parse_failure:entry.NestedEntry)
  return false;
#undef DO_
}

void NestedEntry::SerializeWithCachedSizes(
    ::google::protobuf::io::CodedOutputStream* output) const {
  // @@protoc_insertion_point(serialize_start:entry.NestedEntry)
  ::google::protobuf::uint32 cached_has_bits = 0;
  (void) cached_has_bits;

  cached_has_bits = _has_bits_[0];
  // required string strObj = 1 [default = "hello"];
  if (cached_has_bits & 0x00000001u) {
    ::google::protobuf::internal::WireFormat::VerifyUTF8StringNamedField(
      this->strobj().data(), static_cast<int>(this->strobj().length()),
      ::google::protobuf::internal::WireFormat::SERIALIZE,
      "entry.NestedEntry.strObj");
    ::google::protobuf::internal::WireFormatLite::WriteStringMaybeAliased(
      1, this->strobj(), output);
  }

  // optional int32 int32Obj = 2;
  if (cached_has_bits & 0x00000010u) {
    ::google::protobuf::internal::WireFormatLite::WriteInt32(2, this->int32obj(), output);
  }

  // optional int64 int64Obj = 3;
  if (cached_has_bits & 0x00000008u) {
    ::google::protobuf::internal::WireFormatLite::WriteInt64(3, this->int64obj(), output);
  }

  // optional float floatObj = 4;
  if (cached_has_bits & 0x00000020u) {
    ::google::protobuf::internal::WireFormatLite::WriteFloat(4, this->floatobj(), output);
  }

  // optional double doubleObj = 5;
  if (cached_has_bits & 0x00000040u) {
    ::google::protobuf::internal::WireFormatLite::WriteDouble(5, this->doubleobj(), output);
  }

  // optional bool boolObj = 6;
  if (cached_has_bits & 0x00000080u) {
    ::google::protobuf::internal::WireFormatLite::WriteBool(6, this->boolobj(), output);
  }

  // optional bytes bytesObj = 7;
  if (cached_has_bits & 0x00000002u) {
    ::google::protobuf::internal::WireFormatLite::WriteBytesMaybeAliased(
      7, this->bytesobj(), output);
  }

  // optional .entry.Person person = 8;
  if (cached_has_bits & 0x00000004u) {
    ::google::protobuf::internal::WireFormatLite::WriteMessageMaybeToArray(
      8, this->_internal_person(), output);
  }

  if (_internal_metadata_.have_unknown_fields()) {
    ::google::protobuf::internal::WireFormat::SerializeUnknownFields(
        _internal_metadata_.unknown_fields(), output);
  }
  // @@protoc_insertion_point(serialize_end:entry.NestedEntry)
}

::google::protobuf::uint8* NestedEntry::InternalSerializeWithCachedSizesToArray(
    bool deterministic, ::google::protobuf::uint8* target) const {
  (void)deterministic; // Unused
  // @@protoc_insertion_point(serialize_to_array_start:entry.NestedEntry)
  ::google::protobuf::uint32 cached_has_bits = 0;
  (void) cached_has_bits;

  cached_has_bits = _has_bits_[0];
  // required string strObj = 1 [default = "hello"];
  if (cached_has_bits & 0x00000001u) {
    ::google::protobuf::internal::WireFormat::VerifyUTF8StringNamedField(
      this->strobj().data(), static_cast<int>(this->strobj().length()),
      ::google::protobuf::internal::WireFormat::SERIALIZE,
      "entry.NestedEntry.strObj");
    target =
      ::google::protobuf::internal::WireFormatLite::WriteStringToArray(
        1, this->strobj(), target);
  }

  // optional int32 int32Obj = 2;
  if (cached_has_bits & 0x00000010u) {
    target = ::google::protobuf::internal::WireFormatLite::WriteInt32ToArray(2, this->int32obj(), target);
  }

  // optional int64 int64Obj = 3;
  if (cached_has_bits & 0x00000008u) {
    target = ::google::protobuf::internal::WireFormatLite::WriteInt64ToArray(3, this->int64obj(), target);
  }

  // optional float floatObj = 4;
  if (cached_has_bits & 0x00000020u) {
    target = ::google::protobuf::internal::WireFormatLite::WriteFloatToArray(4, this->floatobj(), target);
  }

  // optional double doubleObj = 5;
  if (cached_has_bits & 0x00000040u) {
    target = ::google::protobuf::internal::WireFormatLite::WriteDoubleToArray(5, this->doubleobj(), target);
  }

  // optional bool boolObj = 6;
  if (cached_has_bits & 0x00000080u) {
    target = ::google::protobuf::internal::WireFormatLite::WriteBoolToArray(6, this->boolobj(), target);
  }

  // optional bytes bytesObj = 7;
  if (cached_has_bits & 0x00000002u) {
    target =
      ::google::protobuf::internal::WireFormatLite::WriteBytesToArray(
        7, this->bytesobj(), target);
  }

  // optional .entry.Person person = 8;
  if (cached_has_bits & 0x00000004u) {
    target = ::google::protobuf::internal::WireFormatLite::
      InternalWriteMessageToArray(
        8, this->_internal_person(), deterministic, target);
  }

  if (_internal_metadata_.have_unknown_fields()) {
    target = ::google::protobuf::internal::WireFormat::SerializeUnknownFieldsToArray(
        _internal_metadata_.unknown_fields(), target);
  }
  // @@protoc_insertion_point(serialize_to_array_end:entry.NestedEntry)
  return target;
}

size_t NestedEntry::ByteSizeLong() const {
// @@protoc_insertion_point(message_byte_size_start:entry.NestedEntry)
  size_t total_size = 0;

  if (_internal_metadata_.have_unknown_fields()) {
    total_size +=
      ::google::protobuf::internal::WireFormat::ComputeUnknownFieldsSize(
        _internal_metadata_.unknown_fields());
  }
  // required string strObj = 1 [default = "hello"];
  if (has_strobj()) {
    total_size += 1 +
      ::google::protobuf::internal::WireFormatLite::StringSize(
        this->strobj());
  }
  if (_has_bits_[0 / 32] & 254u) {
    // optional bytes bytesObj = 7;
    if (has_bytesobj()) {
      total_size += 1 +
        ::google::protobuf::internal::WireFormatLite::BytesSize(
          this->bytesobj());
    }

    // optional .entry.Person person = 8;
    if (has_person()) {
      total_size += 1 +
        ::google::protobuf::internal::WireFormatLite::MessageSize(
          *person_);
    }

    // optional int64 int64Obj = 3;
    if (has_int64obj()) {
      total_size += 1 +
        ::google::protobuf::internal::WireFormatLite::Int64Size(
          this->int64obj());
    }

    // optional int32 int32Obj = 2;
    if (has_int32obj()) {
      total_size += 1 +
        ::google::protobuf::internal::WireFormatLite::Int32Size(
          this->int32obj());
    }

    // optional float floatObj = 4;
    if (has_floatobj()) {
      total_size += 1 + 4;
    }

    // optional double doubleObj = 5;
    if (has_doubleobj()) {
      total_size += 1 + 8;
    }

    // optional bool boolObj = 6;
    if (has_boolobj()) {
      total_size += 1 + 1;
    }

  }
  int cached_size = ::google::protobuf::internal::ToCachedSize(total_size);
  SetCachedSize(cached_size);
  return total_size;
}

void NestedEntry::MergeFrom(const ::google::protobuf::Message& from) {
// @@protoc_insertion_point(generalized_merge_from_start:entry.NestedEntry)
  GOOGLE_DCHECK_NE(&from, this);
  const NestedEntry* source =
      ::google::protobuf::internal::DynamicCastToGenerated<const NestedEntry>(
          &from);
  if (source == NULL) {
  // @@protoc_insertion_point(generalized_merge_from_cast_fail:entry.NestedEntry)
    ::google::protobuf::internal::ReflectionOps::Merge(from, this);
  } else {
  // @@protoc_insertion_point(generalized_merge_from_cast_success:entry.NestedEntry)
    MergeFrom(*source);
  }
}

void NestedEntry::MergeFrom(const NestedEntry& from) {
// @@protoc_insertion_point(class_specific_merge_from_start:entry.NestedEntry)
  GOOGLE_DCHECK_NE(&from, this);
  _internal_metadata_.MergeFrom(from._internal_metadata_);
  ::google::protobuf::uint32 cached_has_bits = 0;
  (void) cached_has_bits;

  cached_has_bits = from._has_bits_[0];
  if (cached_has_bits & 255u) {
    if (cached_has_bits & 0x00000001u) {
      set_has_strobj();
      strobj_.AssignWithDefault(&::entry::NestedEntry::_i_give_permission_to_break_this_code_default_strobj_.get(), from.strobj_);
    }
    if (cached_has_bits & 0x00000002u) {
      set_has_bytesobj();
      bytesobj_.AssignWithDefault(&::google::protobuf::internal::GetEmptyStringAlreadyInited(), from.bytesobj_);
    }
    if (cached_has_bits & 0x00000004u) {
      mutable_person()->::entry::Person::MergeFrom(from.person());
    }
    if (cached_has_bits & 0x00000008u) {
      int64obj_ = from.int64obj_;
    }
    if (cached_has_bits & 0x00000010u) {
      int32obj_ = from.int32obj_;
    }
    if (cached_has_bits & 0x00000020u) {
      floatobj_ = from.floatobj_;
    }
    if (cached_has_bits & 0x00000040u) {
      doubleobj_ = from.doubleobj_;
    }
    if (cached_has_bits & 0x00000080u) {
      boolobj_ = from.boolobj_;
    }
    _has_bits_[0] |= cached_has_bits;
  }
}

void NestedEntry::CopyFrom(const ::google::protobuf::Message& from) {
// @@protoc_insertion_point(generalized_copy_from_start:entry.NestedEntry)
  if (&from == this) return;
  Clear();
  MergeFrom(from);
}

void NestedEntry::CopyFrom(const NestedEntry& from) {
// @@protoc_insertion_point(class_specific_copy_from_start:entry.NestedEntry)
  if (&from == this) return;
  Clear();
  MergeFrom(from);
}

bool NestedEntry::IsInitialized() const {
  if ((_has_bits_[0] & 0x00000001) != 0x00000001) return false;
  if (has_person()) {
    if (!this->person_->IsInitialized()) return false;
  }
  return true;
}

void NestedEntry::Swap(NestedEntry* other) {
  if (other == this) return;
  InternalSwap(other);
}
void NestedEntry::InternalSwap(NestedEntry* other) {
  using std::swap;
  strobj_.Swap(&other->strobj_, &::entry::NestedEntry::_i_give_permission_to_break_this_code_default_strobj_.get(),
    GetArenaNoVirtual());
  bytesobj_.Swap(&other->bytesobj_, &::google::protobuf::internal::GetEmptyStringAlreadyInited(),
    GetArenaNoVirtual());
  swap(person_, other->person_);
  swap(int64obj_, other->int64obj_);
  swap(int32obj_, other->int32obj_);
  swap(floatobj_, other->floatobj_);
  swap(doubleobj_, other->doubleobj_);
  swap(boolobj_, other->boolobj_);
  swap(_has_bits_[0], other->_has_bits_[0]);
  _internal_metadata_.Swap(&other->_internal_metadata_);
}

::google::protobuf::Metadata NestedEntry::GetMetadata() const {
  protobuf_NestedEntry_2eproto::protobuf_AssignDescriptorsOnce();
  return ::protobuf_NestedEntry_2eproto::file_level_metadata[kIndexInFileMessages];
}


// @@protoc_insertion_point(namespace_scope)
}  // namespace entry
namespace google {
namespace protobuf {
template<> GOOGLE_PROTOBUF_ATTRIBUTE_NOINLINE ::entry::NestedEntry* Arena::CreateMaybeMessage< ::entry::NestedEntry >(Arena* arena) {
  return Arena::CreateInternal< ::entry::NestedEntry >(arena);
}
}  // namespace protobuf
}  // namespace google

// @@protoc_insertion_point(global_scope)
