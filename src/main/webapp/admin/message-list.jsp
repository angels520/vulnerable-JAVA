<%--
  Created by IntelliJ IDEA.
  User: lvy
  Date: 2020/3/14
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.fruit.Object.MessageObject" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>欢迎</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="css/font.css">
    <link rel="stylesheet" href="css/xadmin.css">
    <script src="lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/xadmin.js"></script>
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">

                <div class="layui-card-header">
                    <button class="layui-btn" onclick="xadmin.open('添加消息','admin/message-add.html',600,400)"><i
                            class="layui-icon"></i>添加消息
                    </button>
                    <button class="layui-btn" onclick="xadmin.open('修改消息','admin/message-edit.html',600,400)"><i
                            class="layui-icon"></i>修改消息
                    </button>
                </div>
                <div class="layui-card-body layui-table-body layui-table-main">
                    <table class="layui-table layui-form" id="mytable">
                        <thead>
                        <tr>
                            <th>
                                <input type="checkbox" lay-filter="checkall" name="" lay-skin="primary">
                            </th>
                            <th>ID</th>
                            <th>用户名</th>
                            <th>邮箱</th>
                            <th>URL</th>
                            <th>问题</th>
                            <th>消息</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<MessageObject> users = new ArrayList<MessageObject>();
                            if (request.getAttribute("allmessages") != null) {
                                users = (List<MessageObject>) request.getAttribute("allmessages");

                                for (MessageObject user : users) {
                                    out.print("<tr>\n" +
                                            "<td>\n" +
                                            "<input type=\"checkbox\" name=\"id\" value=\"1\"   lay-skin=\"primary\">\n" +
                                            "</td>\n" +
                                            "<td>" + user.getId() + "</td>\n" +
                                            "<td>" + user.getUsername() + "</td>\n" +
                                            "<td>" + user.getEmail() + "</td>\n" +
                                            "<td>" + user.getUrl() + "</td>\n" +
                                            "<td>" + user.getQuestion() + "</td>\n" +
                                            "<td>" + user.getMessage()+ "</td>\n" +
                                            "<td class=\"td-manage\">\n" +
                                            "<a title=\"删除\" href=\"/MessageListServlet?cmd=delmessage&id="+user.getId()+"\">\n" +
                                            "<i class=\"layui-icon\">&#xe640;</i>\n" +
                                            "</a>\n" +
                                            "</td>\n" +
                                            "</tr>\n");
                                }
                            }
                        %>
                        </tbody>
                    </table>
                    <p>
                    <div id="result"></div>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    layui.use(['laydate', 'form'], function () {
        var laydate = layui.laydate;
        var form = layui.form;


        // 监听全选
        form.on('checkbox(checkall)', function (data) {

            if (data.elem.checked) {
                $('tbody input').prop('checked', true);
            } else {
                $('tbody input').prop('checked', false);
            }
            form.render('checkbox');
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });


    });

    /*用户-停用*/
    function member_stop(obj, id) {
        layer.confirm('确认要停用吗？', function (index) {

            if ($(obj).attr('title') == '启用') {

                //发异步把用户状态进行更改
                $(obj).attr('title', '停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!', {icon: 5, time: 1000});

            } else {
                $(obj).attr('title', '启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!', {icon: 5, time: 1000});
            }

        });
    }

    /*用户-删除*/
    function member_del(obj, id) {
        layer.open({
            id:1,
            type: 1,
            title:'删除指定ID',
            skin:'layui-layer-rim',
            area:['450px', 'auto'],

            content: '<form action="/MessageListServlet?cmd=delmessage" method="post">' +
                '<div class="row" style="width: 420px;  margin-left:7px; margin-top:10px;">'
                +'<div class="col-sm-12">'
                +'<div class="input-group">'
                +'<span class="input-group-addon"> ID   :</span>'
                +'<input name="id" type="text" class="form-control" placeholder="ID">'
                +'</div>'
                +'</div>'
                +'<div class="col-sm-12" style="margin-top: 10px">'
                +'<div class="input-group">'
                +'<span class="input-group-addon">提交:</span>'
                +'<input type="submit" value="提交" >'
                +'</div>'
                +'</div>'
                +'</div>'

        });
    }


    function delAll(argument) {
        var ids = [];

        // 获取选中的id
        $('tbody input').each(function (index, el) {
            if ($(this).prop('checked')) {
                ids.push($(this).val())
            }
        });

        layer.confirm('确认要删除吗？' + ids.toString(), function (index) {
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
    }
</script>
</html>