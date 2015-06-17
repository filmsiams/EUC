package projectpea


class EditrequestComposer extends zk.grails.Composer {

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

    	def findst = Request.findByStatus(session.status)    	
    		if(findst != null){    		
    		//1	
		       	$('#name').val(findst.name)
				$('#card').val(findst.card)
				$('#cardno').val(findst.cardno)
				$('#cardd').val(findst.cardd)
				$('#idhome').val(findst.idhome)
				$('#nohome').val(findst.nohome)
				$('#nhome').val(findst.nhome)
				$('#room').val(findst.room)
				$('#floor').val(findst.floor)
				$('#trog').val(findst.trog)
				$('#soy').val(findst.soy)
				$('#road').val(findst.road)
				$('#moo').val(findst.moo)
				$('#tumbon').val(findst.tumbon)
				$('#aumpher').val(findst.aumpher)
				$('#city').val(findst.city)
				$('#post').val(findst.post)
				$('#tel').val(findst.tel)
				$('#fax').val(findst.fax)
				$('#mail').val(findst.mail)
			//2
				$('#base').val(findst.base)
				$('#etc').val(findst.etc)
				$('#namebase').val(findst.namebase)
				$('#idhome2').val(findst.idhome2)
				$('#nohome2').val(findst.nohome2)
				$('#nhome2').val(findst.nhome2)
				$('#room2').val(findst.room2)
				$('#floor2').val(findst.floor2)
				$('#trog2').val(findst.trog2)
				$('#soy2').val(findst.soy2)
				$('#road2').val(findst.road2)
				$('#moo2').val(findst.moo2)
				$('#tumbon2').val(findst.tumbon2)
				$('#aumpher2').val(findst.aumpher2)
				$('#city2').val(findst.city2)
				$('#post2').val(findst.post2)
				$('#tel2').val(findst.tel2)
				$('#fax2').val(findst.fax2)
				$('#mail2').val(findst.mail2)
				$('#typesme').val(findst.typesme)
			//3
				$('#contact').val(findst.contact)
				$('#idhome3').val(findst.idhome3)
				$('#nohome3').val(findst.nohome3)
				$('#nhome3').val(findst.nhome3)
				$('#room3').val(findst.room3)
				$('#floor3').val(findst.floor3)
				$('#trog3').val(findst.trog3)
				$('#soy3').val(findst.soy3)
				$('#road3').val(findst.road3)
				$('#moo3').val(findst.moo3)
				$('#tumbon3').val(findst.tumbon3)
				$('#aumpher3').val(findst.aumpher3)
				$('#city3').val(findst.city3)
				$('#post3').val(findst.post3)
				$('#tel3').val(findst.tel3)
				$('#fax3').val(findst.tel3)
				$('#mail3').val(findst.mail3)
			//4
				$('#want').val(findst.want)
				$('#want2').val(findst.want2)
			//5
				$('#typeuse').val(findst.typeuse)
				$('#typeetc').val(findst.typeetc)			
			//6
				$('#miteruse').val(findst.miteruse)
				$('#miternum').val(findst.miternum)
				$('#airweight').val(findst.airweight)
				$('#airnum').val(findst.airnum)
				$('#lamp').val(findst.lamp)
				$('#plug').val(findst.plug)
				$('#fan').val(findst.fan)
				$('#etc6').val(findst.etc6)				
			//7
				$('#dateuse').val(findst.dateuse)
			//8
				$('#pay').val(findst.pay)
				$('#payment').val(findst.payment)
				$('#idhome4').val(findst.idhome4)
				$('#nohome4').val(findst.nohome4)
				$('#nhome4').val(findst.nhome4)
				$('#room4').val(findst.room4)
				$('#floor4').val(findst.floor4)
				$('#trog4').val(findst.trog4)
				$('#soy4').val(findst.soy4)
				$('#road4').val(findst.road4)
				$('#moo4').val(findst.moo4)
				$('#tumbon4').val(findst.tumbon4)
				$('#aumpher4').val(findst.aumpher4)
				$('#city4').val(findst.city4)
				$('#post4').val(findst.post4)
				$('#tel4').val(findst.tel4)
				$('#fax4').val(findst.fax4)
				$('#mail4').val(findst.mail4)
			
		} else{
				redirect(uri: "/list.zul")
		}

		$('#submit').on('click',{
		if($('#checkinfo').text() == ""){
				alert("ท่านยังไม่อนุมัติการให้บริการ ค่ะ!")
			}
			else{
				def add = Request.findByStatus(session.status)
					if(add != null){

						if($('#typeuse').val() == "บ้านที่อยู่อาศัย"){

							add.nouser = "HH"+add.id

						}else if($('#typeuse').val() == "กิจการขนาดเล็ก"){

							add.nouser = "SS"+add.id

						}else if($('#typeuse').val() == "กิจการขนาดกลาง"){

							add.nouser = "SM"+add.id
							
						}else if($('#typeuse').val() == "กิจการขนาดใหญ่"){

							add.nouser = "SL"+add.id
							
						}else if($('#typeuse').val() == "กิจการเฉพาะอย่าง"){

							add.nouser = "SP"+add.id
							
						}else if($('#typeuse').val() == "ราชการ/องค์กรไม่แสวงหากำไร"){

							add.nouser = "NP"+add.id
							
						}else if($('#typeuse').val() == "สูบน้ำเพื่อการเกษตร"){

							add.nouser = "WP"+add.id
							
						}else if($('#typeuse').val() == "ไฟฟ้าชั่วคราว"){

							add.nouser = "UN"+add.id
							
						}else {
							add.nouser = "ETC"+add.id
						}
					//1
			        	add.name =$('#name').val()
						add.card =$('#card').val()
						add.cardno =$('#cardno').val()
						add.cardd =$('#cardd').val()
						add.idhome =$('#idhome').val()
						add.nohome =$('#nohome').val()
						add.nhome =$('#nhome').val()
						add.room =$('#room').val()
						add.floor =$('#floor').val()
						add.trog =$('#trog').val()
						add.soy =$('#soy').val()
						add.road =$('#road').val()
						add.moo =$('#moo').val()
						add.tumbon =$('#tumbon').val()
						add.aumpher =$('#aumpher').val()
						add.city =$('#city').val()
						add.post =$('#post').val()
						add.tel =$('#tel').val()
						add.fax =$('#fax').val()
						add.mail =$('#mail').val()
					//2
						add.base =$('#base').val()
						add.etc =$('#etc').val()
						add.namebase =$('#namebase').val()
						add.idhome2 =$('#idhome2').val()
						add.nohome2 =$('#nohome2').val()
						add.nhome2 =$('#nhome2').val()
						add.room2 =$('#room2').val()
						add.floor2 =$('#floor2').val()
						add.trog2 =$('#trog2').val()
						add.soy2 =$('#soy2').val()
						add.road2 =$('#road2').val()
						add.moo2 =$('#moo2').val()
						add.tumbon2 =$('#tumbon2').val()
						add.aumpher2 =$('#aumpher2').val()
						add.city2 =$('#city2').val()
						add.post2 =$('#post2').val()
						add.tel2 =$('#tel2').val()
						add.fax2 =$('#fax2').val()
						add.mail2 =$('#mail2').val()
						add.typesme =$('#typesme').val()
					//3
						add.contact =$('#contact').val()
						add.idhome3 =$('#idhome3').val()
						add.nohome3 =$('#nohome3').val()
						add.nhome3 =$('#nhome3').val()
						add.room3 =$('#room3').val()
						add.floor3 =$('#floor3').val()
						add.trog3 =$('#trog3').val()
						add.soy3 =$('#soy3').val()
						add.road3 =$('#road3').val()
						add.moo3 =$('#moo3').val()
						add.tumbon3 =$('#tumbon3').val()
						add.aumpher3 =$('#aumpher3').val()
						add.city3 =$('#city3').val()
						add.post3 =$('#post3').val()
						add.tel3 =$('#tel3').val()
						add.fax3 =$('#fax3').val()
						add.mail3 =$('#mail3').val()
					//4
						add.want =$('#want').val()
						add.want2 =$('#want2').val()
					//5
						add.typeuse =$('#typeuse').val()
						add.typeetc =$('#typeetc').val()			
					//6
						add.miteruse =$('#miteruse').val()
						add.miternum =$('#miternum').val()
						add.airweight =$('#airweight').val()
						add.airnum =$('#airnum').val()
						add.lamp =$('#lamp').val()
						add.plug =$('#plug').val()
						add.fan =$('#fan').val()
						add.etc6 =$('#etc6').val()
						
					//7
						add.dateuse =$('#dateuse').val()
					//8
						add.pay =$('#pay').val()
						add.payment =$('#payment').val()
						add.idhome4 =$('#idhome4').val()
						add.nohome4 =$('#nohome4').val()
						add.nhome4 =$('#nhome4').val()
						add.room4 =$('#room4').val()
						add.floor4 =$('#floor4').val()
						add.trog4 =$('#trog4').val()
						add.soy4 =$('#soy4').val()
						add.road4 =$('#road4').val()
						add.moo4 =$('#moo4').val()
						add.tumbon4 =$('#tumbon4').val()
						add.aumpher4 =$('#aumpher4').val()
						add.city4 =$('#city4').val()
						add.post4 =$('#post4').val()
						add.tel4 =$('#tel4').val()
						add.fax4 =$('#fax4').val()
						add.mail4 =$('#mail4').val()
						add.checkinfo =$('#checkinfo').text()
						add.status = ""
						add.save()

						alert("บันทึกข้อมูลเรียบร้อยแล้วค่ะ")
						redirect(uri: "/list.zul")

						

					}else {
						redirect(uri: "/list.zul")
					}
				}
			})
				
				$('#cancel').on('click',{
					def add = Request.findByStatus(session.status)
					add.status = ""
					redirect(uri: "/list.zul")	
				})
	}
}
