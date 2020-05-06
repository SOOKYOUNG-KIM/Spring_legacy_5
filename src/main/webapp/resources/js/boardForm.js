/**
 * 
 * 
 */

	// $("선택자").action();
	
/* 		var btn = document.getElementById("btn");
		btn.addEventListner("click", function() {
			alert("click");
		}); */

				var result = 1;
				
				
				 $("#add").on("click", function() {
					if(result<6){
						$("#file").append('<div class="form-group"><label for="file">File:</label><input type="file" class="from-control files" name="files"><i class="glyphicon glyphicon-remove remove"></i></div>');
						result++;
					}else{     
						alert("파일은 최대 5개까지 추가 가능합니다.")
					}
				 });

	//------------------------------------------------------------------------------------------------
		
		 $("#contents").summernote({
		  height: 400,
		  callbacks: {
				onImageUpload:function(files, editor) {
					var formData = new FormData();
					formData.append('files', files[0]);	//<inpt type="file" name="">
					$.ajax({
						 type : "POST",
						 url  : "../boardFile/fileInsert",
						 data : formData,
						 enctype : "multipart/form-data",
						 cache:false,
						 contentType:false,
						 processData:false,
						 success:function(imageName){
							 imageName=imageName.trim();
							 $("#contents").summernote('editor.insertImage', imageName);
						 }
					});
				},//onimageUpload END
				onMediaDelete:function(files){
					
					var fileName = $(files[0]).attr("src");
					fileName = fileName.substring(fileName.lastIndexOf("/"));
					console.log(fileName);
					
					$.ajax({
						type : "POST",
						url  : "../boardFile/summerDelete",
						data : {
							fileName:fileName
						},
						success:function(data){
							console.log(data);
						}
						
					});
				}//onMediaDelete END
				
			  }//callbacks END
	 }); 
		 
		//--------------------------------------------------------------------------------------
	
				
				
			 
			 $("#btn").click(function() {
				 //title, contents 데이터 유무 검증
				 var title = $("#title").val();
				 var contents = $("#contents").summernote('code');
				 
				 
				 var ch1 = title != "";
				 var ch2 = $("#contents").summernote('isEmpty');
				 
				 var ch3 = true;
				 $(".files").each(function() {
					 if($(this).val()==''){
						 ch3 = false;
					 }
				 });
				 
				 
				 if(ch1 && !ch2 && ch3){
					 //form 전송(submit 이벤트 강제 발생)
					 <!-- Contents Server null이 될 때 -->
					 /*  $("#con").val(contents);  */
					 
					 $("#frm").submit();
					 
				 }else{
					 //submit 이벤트 종료
					 //alert으로 경고
					 alert("필수 요소는 다 입력해주세요");
				 }
			 });
				 
				 /* 
			var contents = $("#contents").val();
			
			console.log($("#contents").summernote('isEmpty'));
			console.log(title=='');
			console.log(contents=='');
			console.log(title.length);
			console.log(contents.length); */
				 
			 
			 
			 
			 $("#file").on("click", ".remove", function() {
		 		$(this).parent().remove();
				result--; 
				 
			})

		 
		 
//		  $("#contents").summernote({
//			  height: 400,
//			  callbacks: {
//				onImageUpload:function(file) {
//					console.log("upload");
//			
//				}
//			  }
//		 });