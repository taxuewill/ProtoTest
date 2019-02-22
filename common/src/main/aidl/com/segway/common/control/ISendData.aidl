// ISendData.aidl
package com.segway.common.control;

import com.segway.common.entry.Student;
import com.segway.common.entry.Rom;
// Declare any non-default types here with import statements

interface ISendData {
   void sendStudent(in Student student);
   void sendStudentP(in byte[] protoData);
   void sendRom(in Rom rom);
   void sendRomP(in byte[] protoData);
}
