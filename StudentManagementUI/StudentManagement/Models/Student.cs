using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace StudentManagement.Models
{
    public class Student
    {
        public int mssv { get; set; }

        [Required(ErrorMessage = "This field cannot be empty!")]
        public string fullname { get; set; }

        [Required(ErrorMessage = "This field cannot be empty!")]
        public string classname { get; set; }

        public string sex { get; set; }

        [Required(ErrorMessage ="This field cannot be empty!")]
        [Range(0,4, ErrorMessage = "GPA must be between 0 and 4!")]
        public double gpa { get; set; }
        
        public string avatar { get; set; }

        public Student()
        {

        }

    }
}
