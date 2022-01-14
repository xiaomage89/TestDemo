/**
 * 自动表
 * @type {HTMLElement}
 */
var bt_sub = document.getElementById("bt_sub");
bt_sub.onclick = function () {
    var id_v = document.getElementById("id").value;
    var name_v = document.getElementById("name").value;
    var gender_v = document.getElementById("gender").value;

    //获取table
    var add_table = document.getElementsByTagName("table")[0];
    add_table.innerHTML+="<tr>\n" +
        "        <td>"+id_v+"</td>\n" +
        "        <td>"+name_v+"</td>\n" +
        "        <td>"+gender_v+"</td>\n" +
        "        <td><a href=\"javascript:void(0);\" onclick=\"delTr(this);\" >删除</a></td>\n" +
        "    </tr>";
}
function delTr(obj) {
    var table = obj.parentNode.parentNode.parentNode;
    var tr = obj.parentNode.parentNode;
    table.removeChild(tr);

}