//获得所有多选框的对象
	var fav=document.getElementsByName("fav");

//判断是否是全选操作
function checkTest1(th){

	//判断选项是否被勾选
	var flag=th.checked;
	//alert(flag);
	
	
	//通过forech的方法遍历名为fav的有序列表
	for (var i in fav) {
		fav[i].checked=flag;
	}
}

//单选决定全选操作
function checkTest2(){
	
	var flag=true;
	
	/*遍历出去第一个和最后一个fav，后来再处理*/
	for (var i=1;i<fav.length-1;i++) {
		if (!fav[i].checked) {
			flag=false;
			break;
		}
	}
	/*决定是否被勾选，fav[0]代表第一个全选框，fav[1]代表第二个多选框*/
	fav[0].checked=flag;
	fav[fav.length-1].checked=flag;
	//alert(flag);
	
	
	
	//商品的总价格
	var zong=0;
	//统计被勾选对象的数量
	var num=0;
	//统计商品数量
	var spNum=0;
	
	//价格是否统计,遍历第2、3、4个fav
	for (var i=1;i<fav.length-1;i++) {
		//如果被勾选
		if (fav[i].checked) {
			num++;
			
			//获得ul父节点
			var par =fav[i].parentNode.parentNode;
			//获得指定ul下的所有li
			var li= par.getElementsByTagName("li");
			
			//单个商品的总价格:将得到的数据通过￥分开，并取第二个元素
			var z=li[6].innerText.split("￥")[1];
			//获得所有商品的总结格
			zong+=Number(z);
			document.getElementById("zongz").innerText=zong;
			
			//获得商品的数量
			var z2=li[5].getElementsByTagName("input");
			var num2=z2[0].value;
			spNum+=Number(num2);
			//获得商品数量统计对象
			document.getElementById("snum").innerText=spNum;
		}
	}
	if(num==0){
	 	document.getElementById("zongz").innerText=0;	
	 	document.getElementById("snum").innerText=0;
	}
	
}

/*控制数量的增加或减少，注意括号问题*/
function checkTest3(th,sig){
	//就是th，即this传的值
	var pre;
	if (sig=="1") {
		//获得下一个节点对象
		pre=th.nextElementSibling;
		if (Number(pre.value)>0) {
			//获得节点的value的值
			pre.value=Number(pre.value)-1;
		  }
		}else{
			//获得上个节点的对象
			pre=th.previousElementSibling;
			//获得下一个节点对象
			pre.value=Number(pre.value)+1;
		}
		
		
		//计算每个商品的价格
		//获取当前节点的父节点的上一个节点的内容，即每个商品的单价nnerText\innerHTML都可以
		var val=pre.parentNode.previousElementSibling.innerText;
		//计算总价格
		var zong=Number(val)*Number(pre.value);
		//把总价赋值给指定对象
		pre.parentNode.nextElementSibling.innerText="￥"+zong;
}


//删除指定节点
function checkTest4(th){
	//获得父节点div(<a>的父节点（li）的父节点（ul）的父节点div)
	var div=th.parentNode.parentNode.parentNode;
	div.remove();
	
}
