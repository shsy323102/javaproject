function loadSelect(typecode,postionid,selectedname,selectedid){
		
		var $select = $("<select name="+selectedname+"></select>");
		$select.append("<option value=''>---请选择---</option>");
		$("#"+postionid).append($select);
		$.post("${pageContext.request.contextPath }/BaseDictAction", {dict_type_code:typecode},
 		 function(data){
			alert("typecode:"+typecode+" "+"Pid:"+postionid+" "+"Sname:"+selectedname+" "+"Sid:"+selectedid);
 		 $.each(data, function(i, n){
			var $option = $("<option value='"+n['dict_id']+"'>"+n["dict_item_name"]+"</option>");
				if(n['dict_id']==selectedid){
					$option.attr("selected","selected");
				}
				$select.append($option); 
			});
  		},"json");
}	