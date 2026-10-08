package com.example.demo.endpoint;

import com.example.demo.model.SoapUser;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;

@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/demo/webservice";

    @Autowired
    private UserService userService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetUserRequest")
    @ResponsePayload
    public Element handleGetUserRequest(@RequestPayload Element request) throws Exception {
        String idText = request.getElementsByTagNameNS("*", "id").item(0).getTextContent();
        Long userId = Long.parseLong(idText);
        SoapUser user = userService.getUserById(userId);

        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element response = doc.createElementNS(NAMESPACE_URI, "GetUserResponse");
        Element idNode = doc.createElementNS(NAMESPACE_URI, "id");
        Element nameNode = doc.createElementNS(NAMESPACE_URI, "name");
        Element emailNode = doc.createElementNS(NAMESPACE_URI, "email");

        if (user != null) {
            idNode.setTextContent(user.getId().toString());
            nameNode.setTextContent(user.getName());
            emailNode.setTextContent(user.getEmail());
        } else {
            idNode.setTextContent(userId.toString());
            nameNode.setTextContent("Not Found");
            emailNode.setTextContent("N/A");
        }

        response.appendChild(idNode);
        response.appendChild(nameNode);
        response.appendChild(emailNode);
        return response;
    }
}
