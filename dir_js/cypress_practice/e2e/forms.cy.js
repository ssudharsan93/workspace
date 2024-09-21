describe('Form Tests', () => {
    beforeEach(() => {
      cy.visit('/forms')
    })
  
    it('Test Subscribe Form', () => {
        cy.contains(/testing forms/i) // tests to see if the page contains the text 'testing forms'
                                     // in a case insensitive manner.
        cy.getDataTest("subscribe-form").find('input').as('subscribe-input')
        cy.get('@subscribe-input').type('ryan@coderyan.com')
        cy.contains(/Successfully subbed: ryan@coderyan.com/i).should('not.exist')
        cy.getDataTest("subscribe-button").click()
        cy.contains(/Successfully subbed: ryan@coderyan.com/i).should('exist')
        cy.wait(3000)
        cy.contains(/Successfully subbed: ryan@coderyan.com/i).should('not.exist')

        cy.get('@subscribe-input').type('ryan@coderyan.io')
        cy.contains(/Invalid email: ryan@coderyan.io!/i).should('not.exist')
        cy.getDataTest("subscribe-button").click()
        cy.contains(/Invalid email: ryan@coderyan.io!/i).should('exist')
        cy.wait(3000)
        cy.contains(/Invalid email: ryan@coderyan.io!/i).should('not.exist')

        cy.get('@subscribe-input')
        cy.contains(/Fail!/i).should('not.exist')
        cy.getDataTest("subscribe-button").click()
        cy.contains(/Fail!/i).should('exist')
        cy.wait(3000)
        cy.contains(/Fail!/i).should('not.exist')
    })
  
})