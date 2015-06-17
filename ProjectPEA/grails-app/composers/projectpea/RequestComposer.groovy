package projectpea


class RequestComposer extends zk.grails.Composer {

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
	
		$('#submit').on('click',{
        	def add = new Request()

        	if($('#confirm').checked() == false){
					alert("ท่านยังไม่ยืนยัน ค่ะ")
			}
				else{

				add.nouser =""
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
				add.base =$('#base').text()
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
				add.want =$('#want').text()
				add.want2 =$('#want2').val()
			//5
				add.typeuse =$('#typeuse').text()
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
				add.dateuse =$('#dateuse').text()
			//8
				add.pay =$('#pay').text()
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
			//9
				
				add.confirm =$('#confirm').text()
				add.checkinfo = "รอการอนุมัติ"
				add.status = ""
				add.save()	
				
				alert("บันทึกข้อมูลเรียบร้อยแล้วค่ะ")

					redirect(uri: "/list.zul")
				}
		}
	)}
}