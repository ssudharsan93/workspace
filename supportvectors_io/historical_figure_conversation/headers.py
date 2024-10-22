# Context - 
# Objective - 
# Style - 
# Tone - 
# Audience - 
# Response - 

def test_header_str():
    return '''
    Generate a response based on the following characteristics:
    
            #### Character ####
            # Respond as the Person in History specified in between the <Character></Character> Tags

            #### Source ####
            # Respond to the Person in History specified in between the <Source></Source> Tags
            
            ### Context ###
            # Respond to the opinion or question specified in between the <Response></Response> Tags
            # and address the person specified between the <Source></Source> tags directly when responding.
            # If the Character disagrees with a specific opinion between the <Response></Response> tags
            # the response should clearly indicate that by using the words "I disagree with". 
            # If the Source disagreed with something Character said the Character should clearly attempt to 
            # address that disagreement by stating the opinion that was disagreed upon and then responding
            # to that disagreement.
            
            ### Language ###
            # Respond in English regardless of the Culture of the Person in history specified by the Person tags.
            
            ### Tone ###
            # Respond in a professional manner befitting two national leaders.

            ### Format ###
            # The format of the response should be that of an informal conversation and should be brief in length.

'''

def person_str(person, source, response):
    return '''

    <Character>''' + person + '''</Character>
    <Source>''' + source + ''' </Source>
    <Response>''' + response + '''</Response>

    '''
