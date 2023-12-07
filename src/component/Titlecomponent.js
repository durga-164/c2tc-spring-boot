import React,{Component} from "react";
import logo from './logo.svg';

class Titlecomponent extends Component{
  render(){
    return(
<div className="divtitle">

    <center>
    <h1 id="title1"><img src={logo} alt="Logo" className="logoImage" />
    MAX MART    </h1></center>
</div>
    );
  }

}
export default Titlecomponent;