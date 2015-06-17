package projectpea

import org.zkoss.zksandbox.*;
	

class ListComposer extends zk.grails.Composer {

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
 	
	int countlist = 1	
		for(Request r : Request.findAll()){
			
			$('#list > rows').append{
				row{
					label(value:"${countlist}")
                    label(value:r.nouser)
					label(value:r.name)
					label(value:r.base)
					label(value:r.dateuse)

                    if(r.checkinfo=="อนุมัติ"){
                        label(value:r.checkinfo,style:"font-weight:bold;color:green")
                    }else if(r.checkinfo=="ไม่อนุมัติ"){					
					   label(value:r.checkinfo,style:"font-weight:bold;color:red")
                    }else {
                        label(value:r.checkinfo,style:"font-weight:bold")
                    }

					button(id:r.id,image:"/ext/images/img/edit.png")
				}				
		}
	    countlist++
		    $('#list > rows > row > button').on('click',{
		    	def edit = Request.findById(it.target.id)
		    	if(edit != null){

					edit.status = "1"
		    		session.status = edit.status		    		
		    		edit.save()
		    		redirect(uri: "/editrequest.zul")
	    		}else{
	    			redirect(uri: "/index.zul")
	    		}
	    	}
	  	)}	
    }          
}

