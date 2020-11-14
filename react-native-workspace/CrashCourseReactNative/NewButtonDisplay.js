import React from 'react';
import { Button } from "react-native";

//functional component
function NewButtonDisplay(props) { 
    /*
    style={} is alternative, unpreferred way of styling, but notice its
    propertyNames compared to CSS property-names.
    */
    return(
        <Button 
            style = {{backgroundColor: 'white'}}
            title = {"New"}
            onPress = {props.onPress}
        /> 
    );
}
export default NewButtonDisplay;