//新增
function addStudent() {
    $("#add_student").append(
    "<table id='students_addInfo' class='tab-list' border='1'>"
        +"<tr>"
        +"<th>学生ID</th>"
        +"<th>姓名</th>"
        +"<th>出生日期</th>"
        +"<th>平均分</th>"
        +"<th>备注</th>"
        +"<th>操作</th>"
        +"</tr>"
        +"<tr>"
        +"<td><input type='text' id='student_id' name='student_id'></td>"
        +"<td><input type='text' id='student_name' name='student_name'></td>"
        +"<td><input type='text' id='student_birthday' name='student_birthday'></td>"
        +"<td><input type='text' id='student_avgScore' name='student_avgScore'></td>"
        +"<td><input type='text' id='student_description' name='student_description'></td>"
        +"<td><input type=\"button\" onclick=\"submitStudent(this)\" value=\"确认\">&nbsp;&nbsp;<input type=\"button\" onclick=\"cancelStudent()\" value=\"取消\"></td>"
        +"</tr>"
        +"</table>"
    );
}
//新增--取消
function cancelStudent() {
    $("#students_addInfo").remove();
}
//新增--确定
function submitStudent(item) {
    //tr
    var n = $(item).parent().parent();
    //input
    var id = $(n).children().children("input[name='student_id']").val();
    var name = $(n).children().children("input[name='student_name']").val();
    var birthday = $(n).children().children("input[name='student_birthday']").val();
    var avgScore = $(n).children().children("input[name='student_avgScore']").val();
    var description = $(n).children().children("input[name='student_description']").val();
    console.log(id+name+birthday+avgScore+description);
    var parparmData = {
        studentId:id,
        studentName:name,
        birthday:birthday,
        avgScore:avgScore,
        description:description
    };
    $.ajax("/addStudent",{
        type:"post",
        // dataType:"json",
        data:parparmData,
        cache:false,
        success:function (data) {
            if ("success" == data){
                alert("添加成功");
                $("#students_addInfo").remove();
                //刷新数据,新增成功--显示到页面
                $("#students_tbody").append(
                    "<tr>"
                    +"<td>"+ id +"</td>"
                    +"<td>"+ name +"</td>"
                    +"<td>"+ birthday +"</td>"
                    +"<td>"+ avgScore +"</td>"
                    +"<td>"+ description +"</td>"
                    +"<td><input type=\"button\" onclick=\"updateStudent(this)\" value=\"修改\">&nbsp;&nbsp;<input type=\"button\" onclick=\"deleteStudent(this)\" value=\"删除\"></td>"
                    +"</tr>"
                );
            }else {
                alert("添加失败，请重新添加");
            }
        },
        error:function () {
            alert("服务器出错");
        }
    });
}

//显示所有学生信息
function allStudentInfo() {
    $.ajax("/allStudentInfo",{
        type:"post",
        cache:false,
        success:function () {

        },
        error:function () {
            alert("服务器出错");
        }
    });
}
//修改学生信息
function updateStudent(item) {
    //tr
    var n = $(item).parent().parent();
    //td
    var id = $(n).children("td[name='td_student_id']");
    var name = $(n).children("td[name='td_student_name']");
    var birthday = $(n).children("td[name='td_student_birthday']");
    var avgScore = $(n).children("td[name='td_student_avgScore']");
    var description = $(n).children("td[name='td_student_description']");
    var operation = $(n).children("td[name='td_student_update']");
    //保存原始数据
    $(id).data("id",$(id).text());
    $(name).data("name",$(name).text());
    $(birthday).data("birthday",$(birthday).text());
    $(avgScore).data("avgScore",$(avgScore).text());
    $(description).data("description",$(description).text());
    //输入
    // id.html("<input type='text' name='input_student_id' value='"+ $(n).children("td[name='td_student_id']").text() +"'/>");
    name.html("<input type='text' name='input_student_name' value='"+ $(name).text() +"'>");
    birthday.html("<input type='text' name='input_student_birthday' value='"+ $(n).children("td[name='td_student_birthday']").text() +"'/>");
    avgScore.html("<input type='text' name='input_student_avgScore' value='"+ $(n).children("td[name='td_student_avgScore']").text() +"'/>");
    description.html("<input type='text' name='input_student_description' value='"+ $(n).children("td[name='td_student_description']").text() +"'/>");
    //确认和取消按钮
    operation.html("<input type='button' value='确认' onclick='submitUpdateUserInfo(this)'/>&nbsp;&nbsp;<input type='button' value='取消' onclick='cancelUpdateUserInfo(this)'/>");
}
//修改--确定
function submitUpdateUserInfo(item) {

    //tr
    var n = $(item).parent().parent();
    //td
    var name = $(n).children("td[name='td_student_name']");
    var birthday = $(n).children("td[name='td_student_birthday']");
    var avgScore = $(n).children("td[name='td_student_avgScore']");
    var description = $(n).children("td[name='td_student_description']");
    //获取原始数据
    // var sId = $(id).data("id");
    var na = $(name).data("name");
    var bir = $(birthday).data("birthday");
    var avg = $(avgScore).data("avgScore");
    var des = $(description).data("description");
    //input
    var id = $(n).children("td[name='td_student_id']").text();
    var newname = $(n).children().children("input[name='input_student_name']").val();
    var newbirthday = $(n).children().children("input[name='input_student_birthday']").val();
    var newavgScore = $(n).children().children("input[name='input_student_avgScore']").val();
    var newdescription = $(n).children().children("input[name='input_student_description']").val();
    var parparmData = {
        oldName:na,
        oldBirthday:bir,
        oldAvgScore:avg,
        oldDescription:des,
        studentId:id,
        newStudentName:newname,
        newBirthday:newbirthday,
        newAvgScore:newavgScore,
        newDescription:newdescription
    };
    $.ajax("/updateStudent",{
        type:"post",
        data:parparmData,
        cache:false,
        success:function (data) {
            if ("success" == data){
                alert("修改成功");
                //刷新数据
                allStudentInfo();
            }else {
                alert("修改失败，请重新修改");
            }
        },
        error:function () {
            alert("服务器出错");
        }
    });
}
//修改--取消
function cancelUpdateUserInfo(item) {
    //tr
    var n = $(item).parent().parent();
    //td
    var id = $(n).children("td[name='td_student_id']");
    var name = $(n).children("td[name='td_student_name']");
    var birthday = $(n).children("td[name='td_student_birthday']");
    var avgScore = $(n).children("td[name='td_student_avgScore']");
    var description = $(n).children("td[name='td_student_description']");
    var operation = $(n).children("td[name='td_student_update']");
    //获取原始数据
    var sId = $(id).data("id");
    var na = $(name).data("name");
    var bir = $(birthday).data("birthday");
    var avg = $(avgScore).data("avgScore");
    var des = $(description).data("description");
    //返回原样
    id.text(sId);
    name.text(na);
    birthday.text(bir);
    avgScore.text(avg);
    description.text(des);
    operation.html("<input type=\"button\" onclick=\"updateStudent(this)\" value=\"修改\">&nbsp;&nbsp;<input type=\"button\" onclick=\"deleteStudent(this)\" value=\"删除\">");

}
//删除学生信息
function deleteStudent(item) {
    //tr
    var n = $(item).parent().parent();
    //td
    var id = $(n).children("td[name='td_student_id']").text();
    var name = $(n).children("td[name='td_student_name']").text();
    var birthday = $(n).children("td[name='td_student_birthday']").text();
    var avgScore = $(n).children("td[name='td_student_avgScore']").text();
    var description = $(n).children("td[name='td_student_description']").text();
    var parparmData = {
        studentId:id,
        studentName:name,
        birthday:birthday,
        avgScore:avgScore,
        description:description
    };
    $.ajax("/deleteStudent",{
        type:"post",
        // dataType:"json",
        data:parparmData,
        cache:false,
        success:function (data) {
            if ("success" == data){
                alert("删除成功");
                //刷新数据
                allStudentInfo();
            }else {
                alert("删除失败，请重新删除");
            }
        },
        error:function () {
            alert("服务器出错");
        }
    });
}
