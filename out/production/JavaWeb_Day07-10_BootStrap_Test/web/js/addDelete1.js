/**
 * 自动表
 * @type {HTMLElement}
 */
var bt_sub = document.getElementById("bt_sub");
bt_sub.onclick = function () {
    var id_v = document.getElementById("id").value;
    var name_v = document.getElementById("name").value;
    var gender_v = document.getElementById("gender").value;

    //创建td
    var td_id = document.createElement("td");
    td_id.append(id_v)
    var td_name = document.createElement("td");
    td_name.append(name_v)
    var td_gender = document.createElement("td");
    td_gender.append(gender_v)

    //a标签的td
    var td_a = document.createElement("td");
    var ele_a = document.createElement("a");
    ele_a.setAttribute("href","javascript:void(0);");
    ele_a.setAttribute("onclick","delTr(this);");
    var text_a = document.createTextNode("删除");
    ele_a.appendChild(text_a);
    td_a.appendChild(ele_a);

    //创建tr
    var add_tr = document.createElement("tr");
    add_tr.appendChild(td_id);
    add_tr.appendChild(td_name);
    add_tr.appendChild(td_gender);
    add_tr.appendChild(td_a);

    //获取table
    var add_table = document.getElementsByTagName("table")[0];
    add_table.appendChild(add_tr);
}
function delTr(obj) {
    var table = obj.parentNode.parentNode.parentNode;
    var tr = obj.parentNode.parentNode;
    table.removeChild(tr);

}