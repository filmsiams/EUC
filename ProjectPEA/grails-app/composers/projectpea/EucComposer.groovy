package projectpea


class EucComposer extends zk.grails.Composer {

    def afterCompose = { window ->

		Date date = new Date()       
        java.text.SimpleDateFormat tf = new java.text.SimpleDateFormat()        
        tf.applyPattern("HH:mm:ss")

        $('#userlogin').val(session.user)
        def ckn = Logincheck.findByUser(session.user)
        if(ckn == null){
        	alert("ท่านยังไม่ทำการ login ค่ะ")
        	redirect(uri: "/login.zul")
        }

        $('#logout').on('click',{
          def del = Logincheck.findByUser(session.user)
            def ch = Employee.findByEmid(session.user)
                def outadd = Logindata.findByCkin(session.ckin)


            if(ch != null){

                ch.cedit = ""
                ch.editin = ""
                ch.save()
            }else{
                      
            }
                

          if(del != null){            

            outadd.timelogout = tf.format(date)
            outadd.ckin = "out"
            outadd.save()

            session.ckin = ""
            session.user = ""
            session.claim = ""            
            del.delete()

            redirect(uri: "/login.zul")
          }else{
            redirect(uri: "/login.zul")
          }
    })
 	
	
		for(Request r : Request.findAll()){			
			
				if(r.checkinfo == "อนุมัติ"){

					$('#list1 > rows').append{
						row{						
							label(value:r.nouser)
							label(value:r.typeuse)                  
							button(id:r.id,image:"/ext/images/img/edit.png")						
						}				
					}

					$('#list1 > rows > row > button').on('click',{
		    		def euc = Request.findById(it.target.id)
		    		
		    		session.euc = euc.nouser
		    		

		    			if(euc.typeuse == "บ้านที่อยู่อาศัย"){
		    				redirect(uri: "/type1.zul")
		    				}else if(euc.typeuse == "กิจการขนาดเล็ก"){
		    					redirect(uri: "/type2.zul")
		    					}else if(euc.typeuse == "กิจการขนาดกลาง"){
		    						redirect(uri: "/type3.zul")
		    						}else if(euc.typeuse == "กิจการขนาดใหญ่"){
		    							redirect(uri: "/type4.zul")
		    							}else if(euc.typeuse == "กิจการเฉพาะอย่าง"){
		    								redirect(uri: "/type5.zul")
		    								}else if(euc.typeuse == "ราชการ/องค์กรไม่แสวงหากำไร"){
		    									redirect(uri: "/type6.zul")
		    									}else if(euc.typeuse == "สูบน้ำเพื่อการเกษตร"){
		    										redirect(uri: "/type7.zul")
		    										}else if(euc.typeuse == "ไฟฟ้าชั่วคราว"){
		    											redirect(uri: "/type8.zul")
		    											}else {
		    												euc.status = "1"
												    		session.status = euc.status		    		
												    		euc.save()
												    		redirect(uri: "/editrequest.zul")
		    											}    		
	    		
	    			})
				}
		}

		
		$('#sbm').src("ext/images/img/euc1.png")	
		
		$('#sbm').on('click',{						

			def sch = Request.findByNouser($('#search').val())	
					
			 if(sch != null && sch.checkinfo == "อนุมัติ"){

			 $('#sbm').src("ext/images/img/euc2.png")

			 $('#list2 > rows > row').detach()
			 			
				$('#list2 > rows').append{	
					
					row{												
						label(value:sch.nouser)
						label(value:sch.typeuse)
						button(id:sch.nouser,image:"/ext/images/img/edit.png")
										
					}
										
				}	

					$('#list2 > rows > row > button').on('click',{
		    		def eucc = Request.findByNouser(it.target.id)
		    		
		    		session.euc = eucc.nouser		    		

		    			if(eucc.typeuse == "บ้านที่อยู่อาศัย"){
		    				redirect(uri: "/type1.zul")
		    				}else if(eucc.typeuse == "กิจการขนาดเล็ก"){
		    					redirect(uri: "/type2.zul")
		    					}else if(eucc.typeuse == "กิจการขนาดกลาง"){
		    						redirect(uri: "/type3.zul")
		    						}else if(eucc.typeuse == "กิจการขนาดใหญ่"){
		    							redirect(uri: "/type4.zul")
		    							}else if(eucc.typeuse == "กิจการเฉพาะอย่าง"){
		    								redirect(uri: "/type5.zul")
		    								}else if(eucc.typeuse == "ราชการ/องค์กรไม่แสวงหากำไร"){
		    									redirect(uri: "/type6.zul")
		    									}else if(eucc.typeuse == "สูบน้ำเพื่อการเกษตร"){
		    										redirect(uri: "/type7.zul")
		    										}else if(eucc.typeuse == "ไฟฟ้าชั่วคราว"){
		    											redirect(uri: "/type8.zul")
		    											}else {
		    												eucc.status = "1"
												    		session.status = eucc.status		    		
												    		eucc.save()
												    		redirect(uri: "/editrequest.zul")
		    											}	    			
	    			})
				}else {
					alert("ไม่พบผู้ใช้รายนี้ค่ะ")
				}				
			
		})
	}
}