
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ekle</title>
<style>
td{
height: 75px;
}
input[type=text] {
  width: 100%;
  padding: 6px 50px;
  margin: 8px 0;
  box-sizing: border-box;
  border: 1px solid #555;
  outline: none;
}

textarea {
  width: 100%;
  height: 150px;
  padding: 12px 50px;
  box-sizing: border-box;
  border: 1px solid #555;
  border-radius: 4px;
  background-color: #f8f8f8;
  font-size: 16px;
  resize: none;
}
select {
          width: 100%;
          padding: 12px 50px;
          border: 1px solid #555;
          border-radius: 10px;
          font-size: 16px;
          background-color: #254FF1;
          color: white;
          
            display: grid;
  grid-template-areas: "select";
  align-items: center;
  position: relative;

  select,
  &::after {
    grid-area: select;
  }

  min-width: 15ch;
  max-width: 30ch;

  border: 1px solid var(--select-border);
  border-radius: 0.25em;
  padding: 0.25em 0.5em;

  font-size: 1.25rem;
  cursor: pointer;
  line-height: 1.1;

  // Optional styles
  // remove for transparency

  // Custom arrow
  &:not(.select--multiple)::after {
    content: "";
    justify-self: end;
    width: 0.8em;
    height: 0.5em;
    background-color: var(--select-arrow);
    clip-path: polygon(100% 0%, 0 0%, 50% 100%);
  }
}


 input[type=submit]{
  background-color: #254FF1;
  border: 1px;
  border-radius: 10px;
  color: white;
  padding: 16px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}
</style>

<SCRIPT>
function isValid(frm)
{
    var adressCode = frm.adressCode.value;
    var adressType = frm.adressType.value;
    var adress = frm.adress.value;
    var city = frm.city.value;
    if ( adressCode == null || adressCode == "")
    {
        alert("Address code is mandatory");
        return false;
    }  
    if ( adressType == null || adressType == "")
    {
        alert("Address type is mandatory");
        return false;
    }
    if ( adress == null || adress == "")
    {
        alert("Address is mandatory");
        return false;
    } 
    if ( city == null || city == "")
    {
        alert("City is mandatory");
        return false;
    } 
    return true;
}

</SCRIPT>

</head>
<body>
<form id="form" name="form" method="post" action="ekle" onsubmit="return isValid(this)">
<table border="0">
<tr>
<td width="150"><label for="adressCode">*Adress Code:</label></td>
<td> <input type="text" name="adressCode" id="adressCode"/></td>
</tr>
<tr>
<td><label for="adressType">*Adress Type: </label></td>
<td>
<select name="adressType" id="adressType" class="minimal">
<option value="">Please choose</option>
  <option value="invoice">Invoice</option>
  <option value="delivery">Delivery</option>
  <option value="buyer">Buyer</option>
  <option value="other">Other</option>
</select>
</td>
</tr>
<tr>
<td><label for="adress">*Adress: </label></td>
<td><textarea id="adress" name="adress" rows="4" cols="15">
</textarea></td>
</tr>
<tr>
<td><label for="district">District: </label></td>
<td><input type="text" name="district" id="district" /></td>
</tr>
<tr>
<td><label for="zipcode">Zipcode: </label></td>
<td><input type="text" name="zipcode" id="zipcode" /></td>
</tr>
<tr>
<td><label for="city">*City: </label></td>
<td><input type="text" name="city" id="city" /></td>
</tr>

<tr><td></td><td><input type="submit" name="saveAdress" id="saveAdress" value="Save Adress" /></td></tr>
</table>
</form>

</body>
</html>